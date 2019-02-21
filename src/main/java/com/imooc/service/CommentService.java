package com.imooc.service;

import com.imooc.domain.Comment;

public interface CommentService {

	//根据id获取Comment
	public Comment getCommentById(Long id);
	
	//删除Comment
	public void removeComment(Long id);
	
}
