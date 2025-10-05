package com.product.service.product;

import com.product.entity.Category;
import com.product.entity.Product;
import com.product.exception.CategoryNotFoundException;
import com.product.exception.ProductNotFound;
import com.product.model.dto.ProductDto;
import com.product.model.dto.ProductResponse;
import com.product.model.dto.ProductUpdateDto;
import com.product.model.mapper.ProductMapper;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ProductMapper mapper;

    public ProductResponse createProduct(ProductDto productDto){
        Product product=mapper.toEntity(productDto);
        product.setCreated_at(LocalDateTime.now());
        product.setUpdated_at(null);
        product.setStatus("ACTIVE");
        Category category=categoryRepo.findById(productDto.getCategoryId()).orElseThrow(()->{
            throw new CategoryNotFoundException("category not found");
        });
        Product dbProduct=productRepo.save(product);
        return mapper.toResponse(dbProduct);
    }
    public ProductResponse updateProduct(Long id,ProductUpdateDto updateDto){
        Product existingProduct=productRepo.findById(id).orElseThrow(()->{
            throw new ProductNotFound("product not found");
        });
        mapper.updateEntityfromDto(updateDto,existingProduct);
        existingProduct.setUpdated_at(LocalDateTime.now());
        Product product=productRepo.save(existingProduct);
        return  mapper.toResponse(product);
    }
    public void deleteProduct(Long id){
        Product existingProduct=productRepo.findById(id).orElseThrow(()->{
            throw new ProductNotFound("product not found");
        });
        productRepo.deleteById(id);

    }
}
