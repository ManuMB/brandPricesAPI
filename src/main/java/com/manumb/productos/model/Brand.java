package com.manumb.productos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "BRANDS")
public class Brand {

    @Id
    @SequenceGenerator(name = "brand_sequence", sequenceName = "brand_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_sequence")
    private Long id;

    private String brand_name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
