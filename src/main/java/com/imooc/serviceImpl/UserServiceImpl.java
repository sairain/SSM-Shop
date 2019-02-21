package com.imooc.serviceImpl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.domain.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.UserService;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	public void removeUser(Long id) {
		userRepository.delete(id);
	}

	//模糊查询
	@Transactional
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		name="%"+name+"%";
		Page<User> users=userRepository.findByNameLike(name, pageable);
		return users;
	}

	@Transactional
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> listUsersByUsernames(Collection<String> usernames) {
		return userRepository.findByUsernameIn(usernames);
	}

}
