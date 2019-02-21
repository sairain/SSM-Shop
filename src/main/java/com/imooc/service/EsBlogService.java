package com.imooc.service;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.imooc.domain.EsBlog;
import com.imooc.domain.User;
import com.imooc.vo.TagVO;

public interface EsBlogService {
 	
	public void removeEsBlog(String id);
	
	public EsBlog updateEsBlog(EsBlog esBlog);
	
	public EsBlog getEsBlogByBlogId(Long blogId);

	public Page<EsBlog> listNewestEsBlogs(String keyword, Pageable pageable);
 
	public Page<EsBlog> listHotestEsBlogs(String keyword, Pageable pageable);
	
	public Page<EsBlog> listEsBlogs(Pageable pageable);

	public List<EsBlog> listTop5NewestEsBlogs();

	public List<EsBlog> listTop5HotestEsBlogs();
	
	public List<TagVO> listTop30Tags();

	public List<User> listTop12Users();
}
