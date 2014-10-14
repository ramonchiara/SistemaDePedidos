package br.pro.ramon.sdp.daos;

import br.pro.ramon.sdp.models.Usuario;

public interface UsuarioDao {

    Usuario findById(Long id);

    Usuario findByLogin(String login);

    Usuario findByLoginAndSenha(String login, String senha);
}
