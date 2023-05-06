package com.manumb.productos.service;

import com.manumb.productos.model.dto.BrandDTO;

import java.util.Set;

public interface IBrandService {
    void createBrand(BrandDTO brandDTO);
    void deleteBrand(Long id);
    BrandDTO searchBrand(Long id);
    void updateBrand(BrandDTO brandDTO);
    Set<BrandDTO> searchBrand();
}
