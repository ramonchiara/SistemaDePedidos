package br.pro.ramon.sdp.uc.pedidos.helpers;

import br.pro.ramon.sdp.entities.Pedido;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PedidoRenderer extends JLabel implements ListCellRenderer<Pedido> {

    private static final int MAX_LENGTH = 32;

    @Override
    public Component getListCellRendererComponent(JList<? extends Pedido> list, Pedido value, int index, boolean isSelected, boolean cellHasFocus) {
        String descricao = null;

        if (value != null) {
            descricao = value.getDescricao();
            descricao = descricao.replace("\n", " ");
            descricao = descricao.length() > MAX_LENGTH ? descricao.substring(0, MAX_LENGTH) + "..." : descricao;
        }

        setText(descricao);

        return this;
    }

}
