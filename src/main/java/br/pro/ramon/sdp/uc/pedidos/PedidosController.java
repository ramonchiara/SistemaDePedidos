package br.pro.ramon.sdp.uc.pedidos;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.models.Pedido;
import br.pro.ramon.sdp.models.Usuario;
import br.pro.ramon.sdp.uc.login.LoginController;
import br.pro.ramon.sdp.uc.novo.NovoPedidoController;

public class PedidosController {

    private Usuario usuario;
    private PedidosView pedidosView;
    private PedidoDao pedidoDao;

    public PedidosController(Usuario usuario) {
        this.usuario = usuario;
        this.pedidosView = new PedidosView(usuario, this);
        this.pedidoDao = DaoFactory.getPedidoDao();
    }

    public void execute() {
        pedidosView.setVisible(true);
    }

    public void remover(Pedido pedido) {
        if (pedido != null) {
            pedidoDao.delete(pedido.getId());
        }
    }

    public void novoPedido() {
        pedidosView.dispose();

        NovoPedidoController novoPedidoController = new NovoPedidoController(usuario);
        novoPedidoController.execute();
    }

    public void sair() {
        pedidosView.dispose();

        LoginController loginController = new LoginController();
        loginController.execute();
    }

}
