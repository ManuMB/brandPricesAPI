package com.manumb.productos.service;

import com.manumb.productos.model.dto.ProductDTO;

import java.util.Set;

public interface IProductService {

    void createProduct(ProductDTO productDTO);
    void deleteProduct(Long id);
    ProductDTO searchProduct(Long id);
    void updateProduct(ProductDTO productDTO);
    Set<ProductDTO> listProduct();
}
