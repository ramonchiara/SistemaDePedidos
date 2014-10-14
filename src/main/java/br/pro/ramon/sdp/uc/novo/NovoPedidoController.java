package br.pro.ramon.sdp.uc.novo;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import br.pro.ramon.sdp.uc.pedidos.PedidosController;

public class NovoPedidoController {

    private Usuario usuario;
    private NovoPedidoView novoPedidoView;
    private PedidoDao pedidoDao;

    public NovoPedidoController(Usuario usuario) {
        this.usuario = usuario;
        this.novoPedidoView = new NovoPedidoView(this);
        this.pedidoDao = DaoFactory.getPedidoDao();
    }

    public void execute() {
        novoPedidoView.setVisible(true);
    }

    public void voltar() {
        novoPedidoView.dispose();

        PedidosController pedidosController = new PedidosController(usuario);
        pedidosController.execute();
    }

    public void criar(String descricao) {
        if (descricao.trim().isEmpty()) {
            novoPedidoView.showPedidoVazio();
        } else {
            Pedido pedido = new Pedido(descricao, usuario);
            pedidoDao.create(pedido);

            novoPedidoView.dispose();

            PedidosController pedidosController = new PedidosController(usuario);
            pedidosController.execute();
        }
    }

}
