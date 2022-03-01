package com.case3.app.controller;


import com.case3.app.dto.ProductDto.ProductResponseDto;
import com.case3.app.dto.ProductDto.ProductSaveDto;
import com.case3.app.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity save(@RequestBody ProductSaveDto productSaveDto){

        ProductResponseDto productResponseDto = productService.save(productSaveDto);

        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<ProductResponseDto> productResponseDtoList = productService.findAll();

        return ResponseEntity.ok(productResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        ProductResponseDto productResponseDto = productService.findById(id);

        return ResponseEntity.ok(productResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        productService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePrice(@PathVariable Long id, @RequestParam BigDecimal price){

        ProductResponseDto productResponseDto = productService.updatePrice(id, price);

        return ResponseEntity.ok(productResponseDto);
    }
}
