package com.api.productos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.productos.entity.Product;

public interface ProductsDAO extends JpaRepository<Product, Long> {

}
