package com.product.model.mapper;

import com.product.entity.Product;
import com.product.exception.PriceisMissing;
import com.product.exception.ProductDescriptionIsMissing;
import com.product.exception.ProductIdisMissing;
import com.product.exception.ProductNameisMissing;
import com.product.model.dto.ProductDto;
import com.product.model.dto.ProductResponse;
import com.product.model.dto.ProductUpdateDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto dto){
        Product product=new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSku(dto.getSku());
        product.setBrand(dto.getBrand());
        product.setSpecifications(dto.getSpecifications());
        return product;
    }
    public ProductResponse toResponse(Product product){
        ProductResponse response=new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setSku(product.getSku());
        response.setSpecifications(product.getSpecifications());
        response.setStatus(product.getStatus());
        if(product.getCategory()!=null){
            response.setCategoryName(product.getCategory().getName());
        }
        return response;
    }
    public void updateEntityfromDto(ProductUpdateDto request, Product product){
        if(request.getName()!=null){
            product.setName(request.getName());
        }
        else{
            throw new ProductNameisMissing("product id is missing");
        }
        if(request.getDescription()!=null){
            product.setDescription(request.getDescription());
        }
        else{
            throw new ProductDescriptionIsMissing("product description is missing");
        }
        if(request.getPrice()!=null){
            product.setPrice(request.getPrice());
        }
        else{
            throw new PriceisMissing("price is missing");
        }
    }
}
