package com.spring.mvc.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter

public class ProductModel 
{

	@NotBlank(message = "Product name is required")
    private String proName;

    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    private Double proPrice;

    @NotBlank(message = "Product category is required")
    private String proCategory;

    @NotBlank(message = "Product brand is required")
    private String proBrand;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String proDescription;
}