package br.pro.ramon.sdp.daos.jpa;

import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.daos.jpa.helpers.DaoJpa;
import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PedidoDaoJpa extends DaoJpa implements PedidoDao {

    @Override
    public void create(Pedido pedido) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(pedido);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            close(em);
        }
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos;

        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select p from Pedido p order by p.status, p.usuario.login");
            pedidos = query.getResultList();
        } finally {
            close(em);
        }

        return pedidos;
    }

    @Override
    public List<Pedido> findAllByUsuario(Usuario usuario) {
        List<Pedido> pedidos;

        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select p from Pedido p where p.usuario = :usuario order by p.status, p.usuario.login");
            query.setParameter("usuario", usuario);
            pedidos = query.getResultList();
        } finally {
            close(em);
        }

        return pedidos;
    }

    @Override
    public void update(Long id, Pedido pedido) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(pedido);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            close(em);
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Pedido pedido = em.find(Pedido.class, id);
            em.remove(pedido);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            close(em);
        }
    }

}
