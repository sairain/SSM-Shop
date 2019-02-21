package com.imooc.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.imooc.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Page<User> findByNameLike(String name,Pageable pageable);
	public User findByUsername(String username);
	
	//根据名称列表查询用户列表
	public List<User> findByUsernameIn(Collection<String> usernames);
	
}
