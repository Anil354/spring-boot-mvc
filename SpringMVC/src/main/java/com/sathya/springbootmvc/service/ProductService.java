package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;

    public void saveProductDetails(ProductModel productModel) {
       double stockValue;
    	 
        stockValue = productModel.getPrice() * productModel.getQuantity();

        double discountPrice;
        discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
        
        double offerprice;
        offerprice=productModel.getPrice() - discountPrice;
        
        double taxprice;
        taxprice=productModel.getDiscountRate()*18/100;
        
        double finalprice;
        finalprice=offerprice + taxprice;
        
        
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productModel.getName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountRate(productModel.getDiscountRate());
        productEntity.setStockvalue(stockValue); 
        productEntity.setDiscountprice(discountPrice);
        productEntity.setOfferPrice(offerprice);
        productEntity.setTaxprice(taxprice);
        productEntity.setFinalprice(finalprice);
        
        
      
       
        productRepository.save(productEntity);
    }
    
    public List<ProductEntity>getAllproducts()
    {
    	List<ProductEntity>products=productRepository.findAll();
    	return products;
    	
    }
    public ProductEntity searchById(Long id) {
		Optional<ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
	}

	public void deleteproductById(Long id) {
		
		productRepository.deleteById(id);
	}
public void deletetById(Long id) {
		
		productRepository.deleteById(id);
	}
	public ProductModel  editProductById(Long id) {
		Optional<ProductEntity> optionalData= productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product = optionalData.get();
			
			ProductModel productModel = new ProductModel();
			productModel.setName(product.getName());
			productModel.setBrand(product.getBrand());
			productModel.setMadeIn(product.getMadeIn());
			productModel.setPrice(product.getPrice());
			productModel.setQuantity(product.getQuantity());
			productModel.setDiscountRate(product.getDiscountRate());
			return productModel;
		}
		else {
			return null;
		}
	}
public void updateProduct(Long id,ProductModel productModel) {
		
	    Optional<ProductEntity> optionalData = productRepository.findById(id);	    
	    if (optionalData.isPresent()) {
	   
	        ProductEntity entity = optionalData.get();

	       
	        double stockValue = productModel.getPrice() * productModel.getQuantity();
	        double discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
	        double offerPrice = productModel.getPrice() - discountPrice;
	        double taxPrice = offerPrice * 18 / 100; 
	        double finalPrice = offerPrice + taxPrice;

	       
	        entity.setName(productModel.getName());
	        entity.setBrand(productModel.getBrand());
	        entity.setMadeIn(productModel.getMadeIn());
	        entity.setPrice(productModel.getPrice());
	        entity.setQuantity(productModel.getQuantity());
	        entity.setDiscountRate(productModel.getDiscountRate());
	        entity.setStockvalue(stockValue);
	        entity.setDiscountprice(discountPrice);
	        entity.setOfferPrice(offerPrice);
	        entity.setTaxprice(taxPrice);
	        entity.setFinalprice(finalPrice);

	    
	        productRepository.save(entity);
	    } 

	}
}