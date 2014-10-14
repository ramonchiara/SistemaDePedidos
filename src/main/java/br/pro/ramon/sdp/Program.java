package br.pro.ramon.sdp;

import br.pro.ramon.sdp.uc.login.LoginController;

public class Program {

    public static void main(String[] args) {
        LoginController loginController = new LoginController();
        loginController.execute();
    }

}
