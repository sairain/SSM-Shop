package com.imooc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
