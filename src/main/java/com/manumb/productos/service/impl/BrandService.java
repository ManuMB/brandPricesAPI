package com.manumb.productos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manumb.productos.model.Brand;
import com.manumb.productos.model.dto.BrandDTO;
import com.manumb.productos.repository.IBrandRepository;
import com.manumb.productos.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BrandService implements IBrandService {

    @Autowired
    private IBrandRepository iBrandRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void createBrand(BrandDTO brandDTO) {
        Brand brand = objectMapper.convertValue(brandDTO, Brand.class);
        iBrandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        iBrandRepository.deleteById(id);
    }

    @Override
    public BrandDTO searchBrand(Long id) {
        BrandDTO brandDTO = null;

        Optional<Brand> brandSearch = iBrandRepository.findById(id);
        if(brandSearch.isPresent()){
            brandDTO = objectMapper.convertValue(brandSearch, BrandDTO.class);
        }else{
            System.out.println("Brand not found");
        }

        return brandDTO;
    }

    @Override
    public void updateBrand(BrandDTO brandDTO) {
        Brand brand = objectMapper.convertValue(brandDTO, Brand.class);
        iBrandRepository.save(brand);
    }

    @Override
    public Set<BrandDTO> searchBrand() {
        List<Brand> listBrand = iBrandRepository.findAll();
        Set<BrandDTO> setBrandDTO = new HashSet<>();

        for (Brand b : listBrand){
            setBrandDTO.add(objectMapper.convertValue(b, BrandDTO.class));
        }

        return setBrandDTO;
    }
}
