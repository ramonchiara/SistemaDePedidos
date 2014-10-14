package br.pro.ramon.sdp.modelos;

public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private boolean admin;

    public Usuario(String login, String senha) {
        this(login, senha, false);
    }

    public Usuario(String login, String senha, boolean admin) {
        this(null, login, senha, admin);
    }

    public Usuario(Long id, String login, String senha, boolean admin) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean getAdmin() {
        return admin;
    }

}
