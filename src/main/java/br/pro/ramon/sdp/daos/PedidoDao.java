package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.modelos.Pedido;
import java.util.List;

public interface PedidoDao {

    void create(Pedido pedido);

    Pedido findById(Long id);

    List<Pedido> findAll();

    void update(Long id, Pedido pedido);

    void delete(Long id);

}
