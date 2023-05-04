package com.manumb.productos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.Currency;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "PRICES")
public class Price {

    @Id
    @SequenceGenerator(name = "price_sequence", sequenceName = "price_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_sequence")
    private Long id;

    private Long brand_id;
    private Timestamp start_date;
    private Timestamp end_date;
    private Long price_list;
    private Long product_id;
    private boolean priority;
    private Double price;
    private Currency curr;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) //Revisar el funcionamiento del cascadeType.Merge
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "product_id")
    private Product product;
}
