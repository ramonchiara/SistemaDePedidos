package br.pro.ramon.sdp.daos.jpa;

import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.daos.jpa.helpers.DaoJpa;
import br.pro.ramon.sdp.entities.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UsuarioDaoJpa extends DaoJpa implements UsuarioDao {

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = null;

        EntityManager em = getEntityManager();
        try {
            usuario = em.find(Usuario.class, id);
        } catch (NoResultException e) {
        } finally {
            close(em);
        }

        return usuario;
    }

    @Override
    public Usuario findByLogin(String login) {
        Usuario usuario = null;

        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select u from Usuario u where u.login = :login");
            query.setParameter("login", login);
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
        } finally {
            close(em);
        }

        return usuario;
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        Usuario usuario = null;

        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            usuario = (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
        } finally {
            close(em);
        }

        return usuario;
    }

}
