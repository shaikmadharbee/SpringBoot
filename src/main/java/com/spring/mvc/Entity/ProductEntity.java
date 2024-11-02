package com.spring.mvc.Entity;

	

	import java.time.LocalDate;

	import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Entity 
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class ProductEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long proId;

	private String proName;
	private double proPrice;
	private String proBrand;
	
	private double discPrice;
	private String proDescription;
	private String proImage;
	private String proCategory;
	private LocalDate createdAt;
	private String createdBy;

	}



