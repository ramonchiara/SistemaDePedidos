package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.daos.jpa.PedidoDaoJpa;
import br.pro.ramon.sdp.daos.jpa.UsuarioDaoJpa;

public abstract class DaoFactory {

    public static PedidoDao getPedidoDao() {
        return new PedidoDaoJpa();
    }

    public static UsuarioDao getUsuarioDao() {
        return new UsuarioDaoJpa();
    }

}
