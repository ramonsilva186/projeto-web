package br.ifpb.imobiliaria.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("imobiliaria");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
