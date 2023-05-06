package com.manumb.productos.service;

import com.manumb.productos.model.dto.PriceDTO;

import java.util.Set;

public interface IPriceService {
    void createPrice(PriceDTO priceDTO);
    void deletePrice(Long id);
    PriceDTO searchPrice(Long id);
    void updatePrice(PriceDTO priceDTO);
    Set<PriceDTO> updatePrice();
}
