package com.manumb.productos.controller;

import com.manumb.productos.model.dto.PriceDTO;
import com.manumb.productos.service.impl.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;


    @PostMapping("/create")
    public ResponseEntity<?> createPrice(@RequestBody PriceDTO priceDTO){
        priceService.createPrice(priceDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Long id){
        priceService.deletePrice(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public PriceDTO searchPrice(@PathVariable Long id){
        return priceService.searchPrice(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePrice(@RequestBody PriceDTO priceDTO){
        priceService.updatePrice(priceDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public Set<PriceDTO> listAllPrices(){
        return priceService.listAllPrices();
    }
}
