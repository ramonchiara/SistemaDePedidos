package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.daos.mysql.PedidoDaoMySql;
import br.pro.ramon.sdp.daos.mysql.UsuarioDaoMySql;

public abstract class DaoFactory {

    public static PedidoDao getPedidoDao() {
        return new PedidoDaoMySql();
    }

    public static UsuarioDao getUsuarioDao() {
        return new UsuarioDaoMySql();
    }

}
