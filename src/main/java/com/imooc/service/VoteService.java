package com.imooc.service;

import com.imooc.domain.Vote;

public interface VoteService {

	//根据id获取Vote
	public Vote getVoteById(Long id);
	
	public void removeVote(Long id);
	
}
