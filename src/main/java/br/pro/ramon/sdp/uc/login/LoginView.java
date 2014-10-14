package br.pro.ramon.sdp.uc.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame implements ActionListener {

    private LoginController loginController;

    private JLabel lblLogin, lblSenha;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;

        setTitle("Login");

        lblLogin = new JLabel("Login");
        lblSenha = new JLabel("Senha");
        txtLogin = new JTextField();
        txtSenha = new JPasswordField();
        btnLogin = new JButton("Login");

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        JPanel pnlCampos = new JPanel();
        pnlCampos.setLayout(new GridLayout(2, 2, 5, 5));

        pnlCampos.add(lblLogin);
        pnlCampos.add(txtLogin);
        pnlCampos.add(lblSenha);
        pnlCampos.add(txtSenha);

        painel.add(pnlCampos, BorderLayout.CENTER);
        painel.add(btnLogin, BorderLayout.SOUTH);

        setContentPane(painel);
        setSize(200, 120);
        setLocationRelativeTo(null);

        btnLogin.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = txtLogin.getText();
        String senha = String.valueOf(txtSenha.getPassword());

        loginController.logar(login, senha);
    }

    public void showUsuarioInvalido() {
        JOptionPane.showMessageDialog(this, "Usuário inválido!");
    }

}
