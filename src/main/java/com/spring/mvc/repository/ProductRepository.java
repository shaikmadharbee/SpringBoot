package com.spring.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.Entity.ProductEntity;
import com.spring.mvc.model.ProductModel;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>  {

	

}
