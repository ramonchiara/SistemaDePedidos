package br.pro.ramon.sdp.modelos;

public class Pedido {

    private Long id;
    private String descricao;
    private Usuario usuario;
    private String status;

    public Pedido(String descricao, Usuario usuario) {
        this(null, descricao, usuario, "aguardando");
    }

    public Pedido(Long id, String descricao, Usuario usuario, String status) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getStatus() {
        return status;
    }

    public void atender() {
        status = "atendido";
    }

}
