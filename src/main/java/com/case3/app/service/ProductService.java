package com.case3.app.service;

import com.case3.app.converter.ProductMapper;
import com.case3.app.dto.ProductDto.ProductResponseDto;
import com.case3.app.dto.ProductDto.ProductSaveDto;
import com.case3.app.entity.Product;
import com.case3.app.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEntityService productEntityService;


    public ProductResponseDto save(ProductSaveDto productSaveDto){

        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveDto);

        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }


    public List<ProductResponseDto> findAll() {

        List<Product> productList = productEntityService.findAll();

        return ProductMapper.INSTANCE.convertToProductResponseDtoList(productList);
    }

    public ProductResponseDto findById(Long id) {

        Product product = productEntityService.getProductByIdWithControl(id);

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }

    public void delete(Long id) {

        Product product = productEntityService.getProductByIdWithControl(id);

        productEntityService.delete(product);
    }

    public ProductResponseDto updatePrice(Long id, BigDecimal price) {

        Product product = productEntityService.getProductByIdWithControl(id);

        product.setPrice(price);
        product = productEntityService.save(product);

        return ProductMapper.INSTANCE.convertToProductResponseDto(product);
    }
}
