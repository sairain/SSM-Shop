package com.imooc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
