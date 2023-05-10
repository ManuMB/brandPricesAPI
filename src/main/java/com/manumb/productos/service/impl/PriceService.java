package com.manumb.productos.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manumb.productos.model.Price;
import com.manumb.productos.model.dto.PriceDTO;
import com.manumb.productos.repository.IPriceRepository;
import com.manumb.productos.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PriceService implements IPriceService {

    @Autowired
    private IPriceRepository iPriceRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void createPrice(PriceDTO priceDTO) {
        Price price = objectMapper.convertValue(priceDTO, Price.class);
        iPriceRepository.save(price);
    }

    @Override
    public void deletePrice(Long id) {
        iPriceRepository.deleteById(id);
    }

    @Override
    public PriceDTO searchPrice(Long id) {
        PriceDTO priceDTO = null;

        Optional<Price> priceSearch = iPriceRepository.findById(id);
        if(priceSearch.isPresent()){
            priceDTO = objectMapper.convertValue(priceSearch, PriceDTO.class);
        }else{
            System.out.println("Price not found");
        }

        return priceDTO;
    }

    @Override
    public void updatePrice(PriceDTO priceDTO) {
        Price price = objectMapper.convertValue(priceDTO, Price.class);
        iPriceRepository.save(price);
    }

    @Override
    public Set<PriceDTO> listAllPrices() {
        List<Price> listPrice = iPriceRepository.findAll();
        Set<PriceDTO> setPriceDTO = new HashSet<>();

        for (Price p : listPrice){
            setPriceDTO.add(objectMapper.convertValue(p, PriceDTO.class));
        }

        return setPriceDTO;
    }
}
