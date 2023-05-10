package com.manumb.productos.controller;

import com.manumb.productos.model.dto.ProductDTO;
import com.manumb.productos.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ProductDTO searchProduct(@PathVariable Long id){
        return productService.searchProduct(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO){
        productService.updateProduct(productDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public Set<ProductDTO> listAllProducts(){
        return productService.listAllProducts();
    }
}
