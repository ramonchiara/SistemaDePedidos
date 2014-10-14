package br.pro.ramon.sdp.uc.admin;

import br.pro.ramon.sdp.entities.Pedido;
import br.pro.ramon.sdp.entities.Usuario;
import br.pro.ramon.sdp.uc.admin.helpers.AdminPedidoRenderer;
import br.pro.ramon.sdp.uc.admin.helpers.AdminPedidosComboBoxModel;
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

public class AdminPedidosView extends JFrame implements ItemListener, ActionListener, WindowListener {

    private Usuario usuario;
    private AdminPedidosController adminPedidosController;

    private AdminPedidosComboBoxModel adminPedidosComboBoxModel;
    private JComboBox cmbPedidos;
    private JLabel lblDescricao;
    private JTextArea txtDescricao;
    private JCheckBox chkAtendido;
    private JButton btnAtender;

    public AdminPedidosView(Usuario usuario, AdminPedidosController adminPedidosController) {
        this.usuario = usuario;
        this.adminPedidosController = adminPedidosController;

        setTitle("Administrar pedidos");

        adminPedidosComboBoxModel = new AdminPedidosComboBoxModel(usuario);
        cmbPedidos = new JComboBox(adminPedidosComboBoxModel);
        lblDescricao = new JLabel("Descrição");
        txtDescricao = new JTextArea();
        chkAtendido = new JCheckBox("Atendido");
        btnAtender = new JButton("Atender");

        cmbPedidos.setRenderer(new AdminPedidoRenderer());
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

        pnlBotoes.add(btnAtender);

        painel.add(cmbPedidos, BorderLayout.NORTH);
        painel.add(pnlPedido, BorderLayout.CENTER);
        painel.add(pnlBotoes, BorderLayout.SOUTH);

        setContentPane(painel);
        setSize(320, 240);
        setLocationRelativeTo(null);

        cmbPedidos.addItemListener(this);
        btnAtender.addActionListener(this);
        this.addWindowListener(this);
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
        Pedido pedido = (Pedido) cmbPedidos.getSelectedItem();

        adminPedidosController.atender(pedido);

        adminPedidosComboBoxModel.loadPedidos();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // ignore
    }

    @Override
    public void windowClosing(WindowEvent e) {
        adminPedidosController.sair();
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
