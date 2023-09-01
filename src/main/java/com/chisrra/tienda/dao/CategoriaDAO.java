package com.chisrra.tienda.dao;

import com.chisrra.tienda.entities.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Categoria producto) {
        this.entityManager.persist(producto);
    }
    public Categoria actualizar(Categoria categoria) {
       return this.entityManager.merge(categoria);
    }
    public void remover(Categoria categoria) {
        categoria = actualizar(categoria);
        this.entityManager.remove(categoria);
    }

}
