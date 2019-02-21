package com.imooc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.imooc.domain.Blog;
import com.imooc.domain.Catalog;
import com.imooc.domain.User;

public interface BlogService {

	public Blog saveBlog(Blog blog);
	
	public void removeBlog(Long id);
	
	public Blog getBlogById(Long id);
	
	//根据用户进行博客名称分页模糊查询(最新)
	public Page<Blog> listBlogsByTitleVote(User user,String title,Pageable pageable);
	
	//根据用户进行博客名称分页模糊查询(最热)
	public Page<Blog> listBlogsByTitleVoteAndSort(User user,String title,Pageable pageable);
	
	//阅读量递增
	public void readIncrease(Long id);
	
	//发表评论
	public Blog createComment(Long blogId,String commentContent);
	
	//删除评论
	public void removeComment(Long blogId,Long commentId);
	
	//点赞
	public Blog createVote(Long blogId);
	
	//取消点赞
	public void removeVote(Long blogId,Long voteId);
	
	//根据分类进行查询
	public Page<Blog> listBlogsByCatalog(Catalog catalog,Pageable pageable);
	
}
