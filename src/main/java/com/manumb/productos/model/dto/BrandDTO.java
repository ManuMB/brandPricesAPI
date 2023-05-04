package com.manumb.productos.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandDTO {

    private String brand_name;
}
