package com.case3.app.converter;

import com.case3.app.dto.ProductResponseDto;
import com.case3.app.dto.ProductSaveDto;
import com.case3.app.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.security.Policy;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveDto productSaveDto);

    ProductResponseDto convertToProductResponseDto(Product product);

    List<ProductResponseDto> convertToProductResponseDtoList(List<Product> productList);

}
