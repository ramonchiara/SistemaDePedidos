package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.modelos.Usuario;

public interface UsuarioDao {

    Usuario findByLoginAndSenha(String login, String senha);

    Usuario findById(Long id);

}
