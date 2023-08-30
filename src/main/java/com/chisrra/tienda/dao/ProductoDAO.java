package com.chisrra.tienda.dao;

import com.chisrra.tienda.entities.Producto;

import javax.persistence.EntityManager;

public class ProductoDAO {
    private final EntityManager entityManager;

    public ProductoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Producto producto) {
        this.entityManager.persist(producto);
    }
}
