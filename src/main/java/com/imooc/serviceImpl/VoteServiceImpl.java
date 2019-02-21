package com.imooc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Vote;
import com.imooc.repository.VoteRepository;
import com.imooc.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}

	public void removeVote(Long id) {
		voteRepository.delete(id);
	}

}
