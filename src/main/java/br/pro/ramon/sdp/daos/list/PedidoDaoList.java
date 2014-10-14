package br.pro.ramon.sdp.daos.list;

import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoList implements PedidoDao {

    private static final List<Pedido> DB = new ArrayList<>();

    @Override
    public void create(Pedido pedido) {
        DB.add(pedido);
    }

    @Override
    public Pedido findById(Long id) {
        Pedido pedido = null;

        for (int i = 0; i < DB.size(); i++) {
            Pedido p = DB.get(i);

            if (p.getId().equals(id)) {
                pedido = p;
                break;
            }
        }

        return pedido;
    }

    @Override
    public List<Pedido> findAll() {
        return DB;
    }

    @Override
    public void update(Long id, Pedido pedido) {
        for (int i = 0; i < DB.size(); i++) {
            Pedido p = DB.get(i);

            if (p.getId().equals(id)) {
                DB.set(i, pedido);
                break;
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < DB.size(); i++) {
            Pedido p = DB.get(i);

            if (p.getId().equals(id)) {
                DB.remove(i);
                break;
            }
        }
    }

}
