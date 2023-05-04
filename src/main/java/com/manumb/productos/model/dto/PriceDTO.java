package com.manumb.productos.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.sql.Timestamp;
import java.util.Currency;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDTO {

    private Long brand_id;
    private Timestamp start_date;
    private Timestamp end_date;
    private Long price_list;
    private Long product_id;
    private boolean priority;
    private Double price;
    private Currency curr;
}
