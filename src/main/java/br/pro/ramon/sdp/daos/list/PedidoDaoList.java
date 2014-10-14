package br.pro.ramon.sdp.daos.list;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoList implements PedidoDao {

    private static Long sequence = 0L;
    private static List<Pedido> DB;

    public PedidoDaoList() {
        if (DB == null) {
            DB = new ArrayList<>();

            UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();
            Usuario u1 = usuarioDao.findByLogin("teste1");
            Usuario u2 = usuarioDao.findByLogin("teste2");

            create(new Pedido("Pedido 1", u1));
            create(new Pedido("Pedido 2", u1));
            create(new Pedido("Pedido 3", u2));
            create(new Pedido("Pedido 4", u2));
            create(new Pedido("Pedido 5", u2));
        }
    }

    @Override
    public void create(Pedido pedido) {
        DB.add(pedido);
        pedido.setId(sequence);
        sequence++;
    }

    @Override
    public List<Pedido> findAll() {
        return DB;
    }

    @Override
    public List<Pedido> findAllByUsuario(Usuario usuario) {
        List<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < DB.size(); i++) {
            Pedido p = DB.get(i);

            if (p.getUsuario().equals(usuario)) {
                pedidos.add(p);
            }
        }

        return pedidos;
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
