package com.manumb.productos.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manumb.productos.model.Brand;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private String product_name;
    private Brand brand;
}
