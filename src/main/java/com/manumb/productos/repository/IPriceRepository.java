package com.manumb.productos.repository;

import com.manumb.productos.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends JpaRepository<Price,Long> {
}
