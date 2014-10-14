package br.pro.ramon.sdp.daos.jdbc;

import br.pro.ramon.sdp.daos.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoMySql {

    protected Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pedidos", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DaoException(ex);
        }

        return connection;
    }

    protected void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                // ignore
            }
        }
    }

    protected void close(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                // ignore
            }
        }
    }

    protected void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                // ignore
            }
        }
    }

}
