package com.imooc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Authority;
import com.imooc.repository.AuthorityRepository;
import com.imooc.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;
	
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
