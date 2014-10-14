package br.pro.ramon.sdp.entities;

import java.util.Objects;

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

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAtendido() {
        return "atendido".equals(status);
    }

    public void atender() {
        status = "atendido";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
