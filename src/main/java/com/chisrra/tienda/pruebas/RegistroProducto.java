package com.chisrra.tienda.pruebas;

import com.chisrra.tienda.dao.CategoriaDAO;
import com.chisrra.tienda.dao.ProductoDAO;
import com.chisrra.tienda.entities.Categoria;
import com.chisrra.tienda.entities.Producto;
import com.chisrra.tienda.utils.JPAUtils;


import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroProducto {
    public static void main(String[] args) {
        registarProducto();

        //Consultas
        EntityManager entityManager = JPAUtils.getentityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);
        System.out.println(productoDAO.consultarId((long) 1));

        System.out.println("---\nConsulta completa:");
        productoDAO.consultarTodo().forEach(System.out::println);
        System.out.println("---\nBusqueda por nombre:");
        productoDAO.consultarNombre("Samsumg").forEach(System.out::println);
        System.out.println("---\nBusqueda por nombre de la categoria:");
        productoDAO.consultaCategoria("CELULAR").forEach(System.out::println);
        System.out.println("---\nBusqueda del precio de un producto:");
        System.out.println(productoDAO.consultarPrecioDeProducto("Samsumg"));
    }

    private static void registarProducto() {
        Categoria cacelular = new Categoria("CELULAR");
        Producto celular = new Producto("Samsumg", "Celular semi nuevo", new BigDecimal(1000), cacelular);

        EntityManager entityManager = JPAUtils.getentityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();

        categoriaDAO.guardar(cacelular);
        productoDAO.guardar(celular);

       entityManager.getTransaction().commit();
       entityManager.close();
    }
}
