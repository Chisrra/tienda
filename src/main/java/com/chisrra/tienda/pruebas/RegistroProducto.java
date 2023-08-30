package com.chisrra.tienda.pruebas;

import com.chisrra.tienda.dao.CategoriaDAO;
import com.chisrra.tienda.dao.ProductoDAO;
import com.chisrra.tienda.definitions.Categoria;
import com.chisrra.tienda.entities.Producto;
import com.chisrra.tienda.utils.JPAUtils;


import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroProducto {
    public static void main(String[] args) {
        Categoria caCelular = new Categoria("CELULAR");
        Producto cel = new Producto("Samsumg", "Celular semi nuevo", new BigDecimal(1000), caCelular);

        EntityManager entityManager = JPAUtils.getentityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();
        categoriaDAO.guardar(caCelular);
        productoDAO.guardar(cel);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
