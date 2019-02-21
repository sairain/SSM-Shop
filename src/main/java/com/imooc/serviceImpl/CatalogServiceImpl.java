package com.imooc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.Catalog;
import com.imooc.domain.User;
import com.imooc.repository.CatalogRepository;
import com.imooc.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogRepository catalogRepository;
	
	public Catalog saveCatalog(Catalog catalog) {
		//判断重复
		List<Catalog> list=catalogRepository.findByUserAndName(catalog.getUser(), catalog.getName());
		if(list!=null && list.size()>0){
			throw new IllegalArgumentException("该分类已存在");
		}
		return catalogRepository.save(catalog);
	}

	public void removeCatalog(Long id) {
		catalogRepository.delete(id);
	}

	public Catalog getCatalogById(Long id) {
		return catalogRepository.findOne(id);
	}

	public List<Catalog> listCatalogs(User user) {
		return catalogRepository.findByUser(user); 
	}

}
