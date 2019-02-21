package com.imooc.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.imooc.domain.User;

public interface UserService {

	public User saveOrUpdateUser(User user);
	
	public User registerUser(User user);
	
	public void removeUser(Long id);
	
	public User getUserById(Long id);
	
	public Page<User> listUsersByNameLike(String name,Pageable pageable);

	public List<User> listUsersByUsernames(Collection<String> usernamelist);
	
}
