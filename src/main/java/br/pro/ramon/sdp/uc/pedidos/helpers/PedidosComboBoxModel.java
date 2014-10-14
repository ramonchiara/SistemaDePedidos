package br.pro.ramon.sdp.uc.pedidos.helpers;

import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class PedidosComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Usuario usuario;
    private Pedido pedidoSelecionado;
    protected PedidoDao pedidoDao;
    protected List<Pedido> pedidos;

    public PedidosComboBoxModel(Usuario usuario) {
        this.usuario = usuario;
        this.pedidoSelecionado = null;
        this.pedidoDao = DaoFactory.getPedidoDao();

        loadPedidos();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        pedidoSelecionado = (Pedido) anItem;
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return pedidoSelecionado;
    }

    @Override
    public int getSize() {
        return pedidos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return pedidos.get(index);
    }

    public void loadPedidos() {
        pedidos = pedidoDao.findAllByUsuario(usuario);
    }

}
