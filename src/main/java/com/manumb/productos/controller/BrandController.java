package com.manumb.productos.controller;

import com.manumb.productos.model.dto.BrandDTO;
import com.manumb.productos.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){
        brandService.createBrand(brandDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public BrandDTO listAllBrands(@PathVariable Long id){
        return brandService.searchBrand(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBrand(@RequestBody BrandDTO brandDTO){
        brandService.updateBrand(brandDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public Set<BrandDTO> listAllBrands(){
        return brandService.listAllBrands();
    }
}
