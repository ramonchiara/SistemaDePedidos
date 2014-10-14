package br.pro.ramon.sdp.uc.login;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.entities.Usuario;
import br.pro.ramon.sdp.uc.admin.AdminPedidosController;
import br.pro.ramon.sdp.uc.pedidos.PedidosController;

public class LoginController {

    private LoginView loginView;
    private UsuarioDao usuarioDao;

    public LoginController() {
        loginView = new LoginView(this);
        usuarioDao = DaoFactory.getUsuarioDao();
    }

    public void execute() {
        loginView.setVisible(true);
    }

    public void logar(String login, String senha) {
        Usuario usuario = usuarioDao.findByLoginAndSenha(login, senha);

        if (usuario == null) {
            loginView.showUsuarioInvalido();
        } else {
            loginView.dispose();

            if (usuario.isAdmin()) {
                AdminPedidosController adminPedidosController = new AdminPedidosController(usuario);
                adminPedidosController.execute();
            } else {
                PedidosController pedidosController = new PedidosController(usuario);
                pedidosController.execute();
            }
        }
    }

}
