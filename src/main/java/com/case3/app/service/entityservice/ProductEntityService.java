package com.case3.app.service.entityservice;

import com.case3.app.dao.ProductDao;
import com.case3.app.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEntityService {

    private final ProductDao productDao;

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Optional<Product> findById(Long id){
        return productDao.findById(id);
    }

    public Product getProductByIdWithControl(Long id){

        Optional<Product> productOptional = productDao.findById(id);

        Product product;
        if(productOptional.isPresent()){
            product = productOptional.get();
        }else{
            throw new RuntimeException("Product not found!");
        }

        return product;
    }

    public Product save(Product product){
        return productDao.save(product);
    }

    public void delete(Product product){
        productDao.delete(product);
    }


}
