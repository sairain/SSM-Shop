package com.imooc.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.imooc.domain.Blog;
import com.imooc.domain.Catalog;
import com.imooc.domain.Comment;
import com.imooc.domain.EsBlog;
import com.imooc.domain.User;
import com.imooc.domain.Vote;
import com.imooc.repository.BlogRepository;
import com.imooc.service.BlogService;
import com.imooc.service.EsBlogService;

//Blog服务
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private EsBlogService esBlogService;
	
	@Transactional
	public Blog saveBlog(Blog blog) {
		boolean isNew=(blog.getId()==null);
		EsBlog esBlog=null;
		
		Blog returnBlog=blogRepository.save(blog);
		
		if(isNew){
			esBlog=new EsBlog(returnBlog);
		}
		else{
			esBlog=esBlogService.getEsBlogByBlogId(blog.getId());
			esBlog.update(returnBlog);
		}
		esBlogService.updateEsBlog(esBlog);
		return returnBlog;
	}

	@Transactional
	public void removeBlog(Long id) {
		blogRepository.delete(id);
	}

	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
		title="%"+title+"%"; //模糊查询
		Page<Blog> blogs=blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title, user, pageable);
		return blogs;
	}

	@Override
	public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
		title="%"+title+"%";
		Page<Blog> blogs=blogRepository.findByUserAndTitleLike(user, title, pageable);
		return blogs;
	}

	public void readIncrease(Long id) {
		Blog blog=blogRepository.findOne(id);
		blog.setReadSize(blog.getCommentSize()+1);
		this.saveBlog(blog);
	}

	public Blog createComment(Long blogId, String commentContent) {
		Blog originalBlog=blogRepository.findOne(blogId);
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Comment comment=new Comment(user,commentContent);
		originalBlog.addComment(comment);
		return this.saveBlog(originalBlog);
	}

	public void removeComment(Long blogId, Long commentId) {
		Blog originalBlog=blogRepository.findOne(blogId);
		originalBlog.removeComment(commentId);
		this.saveBlog(originalBlog);
	}

	public Blog createVote(Long blogId) {
		Blog originalBlog=blogRepository.findOne(blogId);
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Vote vote=new Vote(user);
		boolean isExist=originalBlog.addVote(vote);
		if(isExist){
			throw new IllegalArgumentException("该用户已经点过赞");
		}
		return this.saveBlog(originalBlog);
	}

	public void removeVote(Long blogId, Long voteId) {
		Blog originalBlog=blogRepository.findOne(blogId);
		originalBlog.removeVote(voteId);
		this.saveBlog(originalBlog);
	}

	public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
		Page<Blog> blogs=blogRepository.findByCatalog(catalog, pageable);
		return blogs;
	}

}
