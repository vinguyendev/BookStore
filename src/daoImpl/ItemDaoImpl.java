package daoImpl;

import dao.ItemDAO;
import data.ConnectionPool;
import models.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {
    @Override
    public ArrayList<Item> findByOrder(int order_id) {
        Item it = new Item();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Item> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM items WHERE order_id=?";

        if(conn!=null) {
            System.out.println("Connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setInt(1,order_id);
                rs=statement.executeQuery();
                while (rs.next()) {
                    it.setId(rs.getInt("id"));
                    it.setAmount(rs.getInt("amount"));
                    it.setBook(new BookDaoImpl().findById(rs.getInt("book_id")));
                    it.setOrder(new OrderDaoImpl().findById(order_id));
                    it.setNameBook(new BookDaoImpl().findById(rs.getInt("book_id")).getName());
                    list.add(it);
                }
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }finally {
                pool.freeConnection(conn);
                if (statement!=null) {
                    try {
                        statement.close();
                        if(rs!=null) rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return list;
    }

    @Override
    public void Insert(Item it) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "INSERT INTO items(book_id,order_id,amount) VALUES (?,?,?)";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1,it.getBook_id());
                statement.setInt(2,it.getOrder_id());
                statement.setInt(3,it.getAmount());
                statement.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                if(statement!=null) {
                    try {
                        statement.close();
                        if(rs!=null) rs.close();
                        pool.freeConnection(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    @Override
    public void Update(Item it) {

    }

    @Override
    public void Delete(int id) {

    }
}
