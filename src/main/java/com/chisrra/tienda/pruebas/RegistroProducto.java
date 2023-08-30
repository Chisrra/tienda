package com.chisrra.tienda.pruebas;

import com.chisrra.tienda.dao.ProductoDAO;
import com.chisrra.tienda.definitions.Categoria;
import com.chisrra.tienda.entities.Producto;
import com.chisrra.tienda.utils.JPAUtils;


import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroProducto {
    public static void main(String[] args) {
        Producto cel = new Producto("Samsumg", "Celular semi nuevo", new BigDecimal(1000), Categoria.CELULARES);

        EntityManager entityManager = JPAUtils.getentityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);

        entityManager.getTransaction().begin();
        productoDAO.guardar(cel);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
