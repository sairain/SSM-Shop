package com.imooc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.domain.Catalog;
import com.imooc.domain.User;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

	//根据用户查询
	public List<Catalog> findByUser(User user);
	
	//根据用户及分类名称查询
	public List<Catalog> findByUserAndName(User user,String name);
	
}
