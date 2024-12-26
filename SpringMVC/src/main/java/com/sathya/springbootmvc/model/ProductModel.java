package com.sathya.springbootmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
	public class ProductModel {
		
		private String name;
		private String brand;
		private String madeIn;
		private double price;
		private int quantity;
		private double discountRate;
			
		
		
		
		
	

}