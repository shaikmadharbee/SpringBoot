package com.spring.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.Entity.ProductEntity;
import com.spring.mvc.model.ProductModel;
import com.spring.mvc.service.ProductService;

import jakarta.validation.Valid;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		ProductModel productModel=new ProductModel(); 
		productModel.setProName("Mobile");
		model.addAttribute("productModel", productModel);
		model.addAttribute("page", "productform");
		
		return "index";
	}
	
//	@PostMapping("/products")
//	public String saveProduct(ProductModel productModel)
//	{
//		productService.saveProductData(productModel);
//		return "success";
		
	//}
	
	    @PostMapping("/products")
	    public String saveProduct(@Valid @ModelAttribute ProductModel productModel, 
	                              BindingResult bindingResult, 
	                              Model model) {
	        if (bindingResult.hasErrors()) {
	            return "add-product"; // Return to the form with error messages
	        }
	        productService.saveProductData(productModel);
	        return "success"; // Redirect or return success page
	    }
	
	@GetMapping("/getProducts")
	
	public String getProduct(Model model)
	{
List<ProductEntity>	products=productService.getAllProducts();
model.addAttribute("products", products);
model.addAttribute("page", "getProducts");
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam Long proId)
	{
		productService.deleteProId(proId);
		return "redirect:getProducts";
	}
	
	@GetMapping("/edit")
public String getForm(@RequestParam Long proId, Model model)
{
	ProductModel productModel=productService.editProduct(proId);
	model.addAttribute("proId", proId);
		model.addAttribute("productModel", productModel);
	return "edit-form";
}
	@PostMapping("/update")

	public String saveUpdatedPRoduct(Long proId, ProductModel productModel)
	{
		//productModel.setProId(proId);
		productService.updateService(proId,productModel);
		return "redirect:getProducts";
	}
	@GetMapping("/aboutus")
	public String aboutPage()
	{
		return "about-us";
	}
	
	@GetMapping("/contactus")
public String contactPage()
{

	return "contact-us";
	
}
	@GetMapping("/getId")
	public String showSearchForm(Model model)
	{
		int proId=0;
		model.addAttribute("proId", proId);
        return "pro-Id"; // Return the view name for the search form
    }
	@PostMapping("/search")
public String saveProId(Long proId,Model model)
{
	ProductEntity productEntity=productService.saveProductId(proId);
	model.addAttribute("product", productEntity);
	return "product-details";
	
}
	@GetMapping("/index")
	public String getHomePage()
	{
		return "index";
		
	}
}