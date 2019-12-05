package data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;
import javax.sql.DataSource;

public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)ic.lookup("java:/comp/env/jdbc/bookstore3");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if(pool==null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
