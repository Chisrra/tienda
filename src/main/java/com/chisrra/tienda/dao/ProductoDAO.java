package com.chisrra.tienda.dao;

import com.chisrra.tienda.entities.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDAO {
    private final EntityManager entityManager;

    public ProductoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Producto producto) {
        this.entityManager.persist(producto);
    }
    public Producto consultarId(Long id) {
        return entityManager.find(Producto.class, id);
    }
    public List<Producto> consultarTodo() {
        String jpql = "SELECT P FROM Producto AS P";
        return entityManager.createQuery(jpql, Producto.class).getResultList();
    }
    public List<Producto> consultarNombre(String nombre) {
        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre = :nombre";
        return entityManager.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }
    public List<Producto> consultaCategoria(String nombre) {
        String jqpl = "SELECT P FROM Producto AS P WHERE P.categoria.name = :categoria";
        return entityManager.createQuery(jqpl, Producto.class).setParameter("categoria", nombre).getResultList();
    }
    public BigDecimal consultarPrecioDeProducto(String nombre) {
        String jqpl = "SELECT P.precio from Producto AS P WHERE P.nombre = :nombre";
        return entityManager.createQuery(jqpl, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }
}
