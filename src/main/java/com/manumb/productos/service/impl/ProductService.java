package com.manumb.productos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manumb.productos.model.Product;
import com.manumb.productos.model.dto.ProductDTO;
import com.manumb.productos.repository.IProductRepository;
import com.manumb.productos.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = objectMapper.convertValue(productDTO, Product.class);
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public ProductDTO searchProduct(Long id) {
        ProductDTO productDTO = null;

        Optional<Product> productSearch = iProductRepository.findById(id);
        if(productSearch.isPresent()){
            productDTO = objectMapper.convertValue(productSearch, ProductDTO.class);
        }else{
            System.out.println("Product not found");
        }

        return productDTO;
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = objectMapper.convertValue(productDTO, Product.class);
        iProductRepository.save(product);
    }

    @Override
    public Set<ProductDTO> listAllProducts() {
        List<Product> listProduct = iProductRepository.findAll();
        Set<ProductDTO> setProductDTO = new HashSet<>();

        for(Product p : listProduct){
            setProductDTO.add(objectMapper.convertValue(p, ProductDTO.class));
        }

        return setProductDTO;
    }
}
