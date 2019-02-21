package com.imooc.service;

import java.util.List;

import com.imooc.domain.Catalog;
import com.imooc.domain.User;

public interface CatalogService {

	public Catalog saveCatalog(Catalog catalog);
	
	public void removeCatalog(Long id);
	
	public Catalog getCatalogById(Long id);
	
	//获取Catalog列表
	public List<Catalog> listCatalogs(User user);
	
}
