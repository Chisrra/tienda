package com.chisrra.tienda.dao;

import com.chisrra.tienda.definitions.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Categoria producto) {
        this.entityManager.persist(producto);
    }
}
