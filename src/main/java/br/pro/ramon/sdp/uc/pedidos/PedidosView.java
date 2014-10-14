package br.pro.ramon.sdp.uc.pedidos;

import br.pro.ramon.sdp.models.Pedido;
import br.pro.ramon.sdp.models.Usuario;
import br.pro.ramon.sdp.uc.pedidos.helpers.PedidoRenderer;
import br.pro.ramon.sdp.uc.pedidos.helpers.PedidosComboBoxModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PedidosView extends JFrame implements ItemListener, ActionListener, WindowListener {

    private Usuario usuario;
    private PedidosController pedidosController;

    private PedidosComboBoxModel pedidosComboBoxModel;
    private JComboBox cmbPedidos;
    private JLabel lblDescricao;
    private JTextArea txtDescricao;
    private JCheckBox chkAtendido;
    private JButton btnRemover, btnNovo;

    public PedidosView(Usuario usuario, PedidosController pedidosController) {
        this.usuario = usuario;
        this.pedidosController = pedidosController;

        setTitle("Pedidos - " + usuario.getLogin());

        pedidosComboBoxModel = new PedidosComboBoxModel(usuario);
        cmbPedidos = new JComboBox(pedidosComboBoxModel);
        lblDescricao = new JLabel("Descrição");
        txtDescricao = new JTextArea();
        chkAtendido = new JCheckBox("Atendido");
        btnRemover = new JButton("Remover");
        btnNovo = new JButton("Novo");

        cmbPedidos.setRenderer(new PedidoRenderer());
        txtDescricao.setEditable(false);
        chkAtendido.setEnabled(false);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JPanel pnlPedido = new JPanel();
        pnlPedido.setLayout(new BorderLayout());

        pnlPedido.add(lblDescricao, BorderLayout.NORTH);
        pnlPedido.add(txtDescricao, BorderLayout.CENTER);
        pnlPedido.add(chkAtendido, BorderLayout.SOUTH);

        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlBotoes.add(btnRemover);
        pnlBotoes.add(btnNovo);

        painel.add(cmbPedidos, BorderLayout.NORTH);
        painel.add(pnlPedido, BorderLayout.CENTER);
        painel.add(pnlBotoes, BorderLayout.SOUTH);

        setContentPane(painel);
        setSize(320, 240);
        setLocationRelativeTo(null);

        cmbPedidos.addItemListener(this);
        btnRemover.addActionListener(this);
        btnNovo.addActionListener(this);
        addWindowListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String descricao = null;
        boolean atendido = false;

        Pedido pedido = (Pedido) cmbPedidos.getSelectedItem();

        if (pedido != null) {
            descricao = pedido.getDescricao();
            atendido = pedido.isAtendido();
        }

        txtDescricao.setText(descricao);
        chkAtendido.setSelected(atendido);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRemover) {
            Pedido pedido = (Pedido) cmbPedidos.getSelectedItem();

            pedidosController.remover(pedido);

            pedidosComboBoxModel.loadPedidos();
        } else {
            pedidosController.novoPedido();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowClosing(WindowEvent e) {
        pedidosController.sair();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // ignore
    }

}
