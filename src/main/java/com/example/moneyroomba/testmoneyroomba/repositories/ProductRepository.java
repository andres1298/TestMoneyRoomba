package com.example.moneyroomba.testmoneyroomba.repositories;

import com.example.moneyroomba.testmoneyroomba.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
