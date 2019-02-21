package com.imooc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Comment;
import com.imooc.repository.CommentRepository;
import com.imooc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

	public void removeComment(Long id) {
		commentRepository.delete(id);
	}

}
