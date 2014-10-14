package br.pro.ramon.sdp.daos.list;

import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoList implements UsuarioDao {

    private static List<Usuario> DB = null;

    public UsuarioDaoList() {
        if (DB == null) {
            DB = new ArrayList<>();

            DB.add(new Usuario("admin", "admin", true));
            DB.add(new Usuario("teste1", "teste1"));
            DB.add(new Usuario("teste2", "teste2"));
        }
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        Usuario usuario = null;

        for (int i = 0; i < DB.size(); i++) {
            Usuario u = DB.get(i);

            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                usuario = u;
                break;
            }
        }

        return usuario;
    }

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = null;

        for (int i = 0; i < DB.size(); i++) {
            Usuario u = DB.get(i);

            if (u.getId().equals(id)) {
                usuario = u;
                break;
            }
        }

        return usuario;
    }

}
