package br.pro.ramon.sdp.uc.admin.helpers;

import br.pro.ramon.sdp.models.Pedido;
import br.pro.ramon.sdp.uc.pedidos.helpers.PedidoRenderer;
import java.awt.Component;
import javax.swing.JList;

public class AdminPedidoRenderer extends PedidoRenderer {

    @Override
    public Component getListCellRendererComponent(JList<? extends Pedido> list, Pedido value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        String descricao = getText();

        if (value != null) {
            descricao = descricao + " (" + value.getUsuario().getLogin() + ")";
        }

        setText(descricao);

        return this;
    }

}
