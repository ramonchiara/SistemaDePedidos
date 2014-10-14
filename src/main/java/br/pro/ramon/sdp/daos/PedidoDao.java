package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import java.util.List;

public interface PedidoDao {

    void create(Pedido pedido);

    List<Pedido> findAll();

    List<Pedido> findAllByUsuario(Usuario usuario);

    void update(Long id, Pedido pedido);

    void delete(Long id);

}
