package br.pro.ramon.sdp.daos.jdbc.mysql;

import br.pro.ramon.sdp.daos.DaoException;
import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.daos.jdbc.DaoMySql;
import br.pro.ramon.sdp.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDaoMySql extends DaoMySql implements UsuarioDao {

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from usuarios where id = ?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                boolean admin = resultSet.getBoolean("admin");

                usuario = new Usuario(id, login, senha, admin);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }

        return usuario;
    }

    @Override
    public Usuario findByLogin(String login) {
        Usuario usuario = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from usuarios where login = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String senha = resultSet.getString("senha");
                boolean admin = resultSet.getBoolean("admin");

                usuario = new Usuario(id, login, senha, admin);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }

        return usuario;
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        Usuario usuario = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from usuarios where login = ? and senha = ?");
            statement.setString(1, login);
            statement.setString(2, senha);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                boolean admin = resultSet.getBoolean("admin");

                usuario = new Usuario(id, login, senha, admin);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }

        return usuario;
    }

}
