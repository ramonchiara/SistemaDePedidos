package br.pro.ramon.sdp.daos.jdbc.mysql;

import br.pro.ramon.sdp.daos.DaoException;
import br.pro.ramon.sdp.daos.DaoFactory;
import br.pro.ramon.sdp.daos.PedidoDao;
import br.pro.ramon.sdp.daos.UsuarioDao;
import br.pro.ramon.sdp.daos.jdbc.DaoMySql;
import br.pro.ramon.sdp.models.Pedido;
import br.pro.ramon.sdp.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoMySql extends DaoMySql implements PedidoDao {

    private UsuarioDao usuarioDao;

    public PedidoDaoMySql() {
        usuarioDao = DaoFactory.getUsuarioDao();
    }

    @Override
    public void create(Pedido pedido) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("insert into pedidos (descricao, id_usuario, status) values (?, ?, ?)");
            statement.setString(1, pedido.getDescricao());
            statement.setLong(2, pedido.getUsuario().getId());
            statement.setString(3, pedido.getStatus());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public List<Pedido> findAll() {
        List<Pedido> pedidos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from pedidos p join usuarios u on p.id_usuario = u.id order by p.status, u.login");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                Long idUsuario = resultSet.getLong("id_usuario");
                String status = resultSet.getString("status");

                Usuario usuario = usuarioDao.findById(idUsuario);
                Pedido pedido = new Pedido(id, descricao, usuario, status);

                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }

        return pedidos;
    }

    @Override
    public List<Pedido> findAllByUsuario(Usuario usuario) {
        List<Pedido> pedidos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("select * from pedidos p join usuarios u on p.id_usuario = u.id where u.id = ? order by p.status, u.login");
            statement.setLong(1, usuario.getId());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String descricao = resultSet.getString("descricao");
                String status = resultSet.getString("status");

                Pedido pedido = new Pedido(id, descricao, usuario, status);

                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }

        return pedidos;
    }

    @Override
    public void update(Long id, Pedido pedido) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("update pedidos set descricao = ?, id_usuario = ?, status = ? where id = ?");
            statement.setString(1, pedido.getDescricao());
            statement.setLong(2, pedido.getUsuario().getId());
            statement.setString(3, pedido.getStatus());
            statement.setLong(4, pedido.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(statement);
            close(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("delete from pedidos where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        } finally {
            close(statement);
            close(connection);
        }
    }

}
