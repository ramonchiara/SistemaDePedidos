package br.pro.ramon.sdp.uc.admin.helpers;

import br.pro.ramon.sdp.entities.Usuario;
import br.pro.ramon.sdp.uc.pedidos.helpers.PedidosComboBoxModel;

public class AdminPedidosComboBoxModel extends PedidosComboBoxModel {

    public AdminPedidosComboBoxModel(Usuario usuario) {
        super(usuario);
    }

    @Override
    public void loadPedidos() {
        pedidos = pedidoDao.findAll();
    }
}
