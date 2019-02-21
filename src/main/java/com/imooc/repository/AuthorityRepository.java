package com.imooc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imooc.domain.Authority;

//Authority仓库
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
