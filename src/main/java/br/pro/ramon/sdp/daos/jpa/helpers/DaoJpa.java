package br.pro.ramon.sdp.daos.jpa.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoJpa {

    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("SistemaDePedidosPu");
        EntityManager em = emf.createEntityManager();

        return em;
    }

    public void close(EntityManager em) {
        em.close();
        // emf.close();
    }

}
