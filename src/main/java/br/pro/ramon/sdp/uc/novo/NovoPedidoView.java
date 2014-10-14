package br.pro.ramon.sdp.uc.novo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NovoPedidoView extends JFrame implements ActionListener {

    private NovoPedidoController novoPedidoController;

    private JLabel lblPedido;
    private JTextArea txtDescricao;
    private JButton btnVoltar, btnCriar;

    public NovoPedidoView(NovoPedidoController novoPedidoController) {
        this.novoPedidoController = novoPedidoController;

        setTitle("Novo pedido");

        lblPedido = new JLabel("Pedido");
        txtDescricao = new JTextArea();
        btnVoltar = new JButton("Voltar");
        btnCriar = new JButton("Criar");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlBotoes.add(btnVoltar);
        pnlBotoes.add(btnCriar);

        painel.add(lblPedido, BorderLayout.NORTH);
        painel.add(new JScrollPane(txtDescricao), BorderLayout.CENTER);
        painel.add(pnlBotoes, BorderLayout.SOUTH);

        setContentPane(painel);
        setSize(320, 240);
        setLocationRelativeTo(null);

        btnVoltar.addActionListener(this);
        btnCriar.addActionListener(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVoltar) {
            novoPedidoController.voltar();
        } else {
            String descricao = txtDescricao.getText();

            novoPedidoController.criar(descricao);
        }
    }

    public void showPedidoVazio() {
        JOptionPane.showMessageDialog(this, "Pedido não pode estar vazio!");
    }

}
