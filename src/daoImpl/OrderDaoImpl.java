package daoImpl;

import dao.OrderDAO;
import data.ConnectionPool;
import models.Book;
import models.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDAO {
    @Override
    public ArrayList<Order> findAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Order> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM orders";

        if(conn!=null) {
            System.out.println("Connected...");
            try {
                statement=conn.prepareStatement(sql);
                rs=statement.executeQuery();
                while (rs.next()) {
                    Order or = new Order();
                    or.setId(rs.getInt("id"));
                    or.setCustomer(new UserDaoImpl().findById(rs.getInt("user_id")));
                    or.setDate(rs.getString("date"));
                    or.setTotal(rs.getDouble("total"));
                    or.setStatus(rs.getInt("status"));
                    or.setNameCus(new UserDaoImpl().findById(rs.getInt("user_id")).getFullName());
                    list.add(or);
                }
            } catch (SQLException e) {
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

        return list;
    }

    @Override
    public void Insert(Order or) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "INSERT INTO orders(user_id,date,total,status) VALUES (?,?,?,?)";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1,or.getCustomer_id());
                statement.setString(2,or.getDate());
                statement.setDouble(3,or.getTotal());
                statement.setInt(4,or.getStatus());
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
    public void Update(Order or) {

    }

    @Override
    public void Delete(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "DELETE FROM orders WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql);
                statement.setInt(1,id);
                int i = statement.executeUpdate();
                if(i>0) {
                    System.out.println("delete success");
                    conn.commit();
                }
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                pool.freeConnection(conn);
                if(statement!=null) {
                    try {
                        statement.close();
                        if(rs!=null) rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    @Override
    public Order findById(int id) {
        Order or = new Order();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM orders WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setInt(1,id);
                rs=statement.executeQuery();
                while (rs.next()) {
                    or.setId(rs.getInt("id"));
                    or.setCustomer(new UserDaoImpl().findById(rs.getInt("user_id")));
                    or.setDate(rs.getString("date"));
                    or.setTotal(rs.getDouble("total"));
                    or.setStatus(rs.getInt("status"));
                    or.setNameCus(new UserDaoImpl().findById(rs.getInt("user_id")).getFullName());
                }
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } finally {
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
        return or;
    }

    @Override
    public int findOrderNew() {
        int id = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM orders WHERE id=(SELECT MAX(id) FROM orders)";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                rs=statement.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                }
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } finally {
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
        System.out.println(id);

        return id;
    }
}
