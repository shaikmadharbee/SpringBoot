package com.spring.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.Entity.ProductEntity;
import com.spring.mvc.model.ProductModel;
import com.spring.mvc.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveProductData(ProductModel productModel)
	{
		double price=productModel.getProPrice();
		String category=productModel.getProCategory();
		double discPrice=9000;
		switch (category) 
		{
        case "mobile":
            discPrice = (price*0.1)-price;  // 10% discount
            break;
        case "camera":
        	discPrice = (price*0.15)-price;  // 15% discount 
            break;
        case "laptop":
        	discPrice = (price*0.2)-price; // 20% discount
            break;
        case "printer":
        	discPrice = (price*0.25)-price; // 5% discount
            break;
       
    }
		
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setProName(productModel.getProName());
		productEntity.setDiscPrice(productModel.getProPrice());
		productEntity.setProBrand(productModel.getProBrand());
		productEntity.setProDescription(productModel.getProDescription());
		productEntity.setProCategory(productModel.getProCategory());
		productEntity.setDiscPrice(discPrice);
		productEntity.setCreatedAt(LocalDate.now());
		productEntity.setCreatedBy(System.getProperty("user.name"));
		
		
		productRepository.save(productEntity);
		
		
	}
	
	public List<ProductEntity> getAllProducts()
	{
	List<ProductEntity>products=productRepository.findAll();
	return products;
	}

	public void deleteProId(Long proId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(proId);
	}

	public ProductModel editProduct(Long proId) {
	
		Optional<ProductEntity> products=productRepository.findById(proId);
	ProductEntity produEntity=null;
		ProductModel productModel=new ProductModel();
		if(products.isPresent())
		{
			 produEntity = products.get();
		}
		
		productModel.setProName(produEntity.getProName());
		productModel.setProPrice(produEntity.getProPrice());
		productModel.setProBrand(produEntity.getProBrand());
		productModel.setProCategory(produEntity.getProCategory());
		productModel.setProDescription(produEntity.getProDescription());
		
		return productModel;
	}

	
	

	public void updateService(Long id,ProductModel productModel) {
		// TODO Auto-generated method stub
Optional<ProductEntity> productEntityoptional=productRepository.findById(id);
		
		if(productEntityoptional.isPresent())
		{
			ProductEntity productEntity=productEntityoptional.get();
			
			Double price=productModel.getProPrice();
			String catgory=productModel.getProCategory();
			Double discountPrice=0.0;
			 switch (catgory.toLowerCase()) {
		     case "mobile":
		    	 discountPrice = price * 0.1; 
		         break;
		     case "laptop":
		    	 discountPrice = price * 0.15;
		         break;
		     case "printer":
		    	 discountPrice  = price * 0.2;
		         break;
		     case "camera":
		    	 discountPrice  = price * 0.25;
		         break;
			 }
			
			 // Update the entity with new values from ProductModel (DTO)
            productEntity.setProName(productModel.getProName());
            productEntity.setProPrice(price);
            productEntity.setProBrand(productModel.getProBrand());
            productEntity.setProDescription(productModel.getProDescription());
            productEntity.setProCategory(productModel.getProCategory());
            productEntity.setDiscPrice(discountPrice);

            // Save the updated entity back to the database
            productRepository.save(productEntity);
		}
		
	}

	public ProductEntity saveProductId(Long proId) {
		// TODO Auto-generated method stub
		Optional<ProductEntity> productOp=productRepository.findById(proId);
		ProductEntity productEntity=null;
		if(productOp.isPresent())
		{
			productEntity=productOp.get();
		}
		return productEntity;
	}

	
		
	}

	

