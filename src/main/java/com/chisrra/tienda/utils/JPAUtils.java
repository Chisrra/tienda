package com.chisrra.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda");

    public static EntityManager getentityManager() {
        return FACTORY.createEntityManager();
    }
}
