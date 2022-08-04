package com.example.basketapi.repositorie;

import com.example.basketapi.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepositorie extends JpaRepository<Basket, Long> {
    List<Basket> findBasketByName(String name);
}
