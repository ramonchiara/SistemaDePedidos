package br.pro.ramon.sdp.uc.admin;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.models.Pedido;
import br.pro.ramon.sdp.models.Usuario;
import br.pro.ramon.sdp.uc.login.LoginController;

public class AdminPedidosController {

    private AdminPedidosView adminPedidosView;
    private PedidoDao pedidoDao;

    public AdminPedidosController(Usuario usuario) {
        this.adminPedidosView = new AdminPedidosView(usuario, this);
        this.pedidoDao = DaoFactory.getPedidoDao();
    }

    public void execute() {
        adminPedidosView.setVisible(true);
    }

    public void atender(Pedido pedido) {
        if (pedido != null) {
            pedido.atender();

            pedidoDao.update(pedido.getId(), pedido);
        }
    }

    public void sair() {
        adminPedidosView.dispose();

        LoginController loginController = new LoginController();
        loginController.execute();
    }

}
