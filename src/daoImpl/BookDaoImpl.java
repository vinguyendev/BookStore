package daoImpl;

import dao.BookDAO;
import data.ConnectionPool;
import models.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDaoImpl implements BookDAO {

    @Override
    public ArrayList<Book> findAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Book> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM book";

        if(conn!=null) {
            System.out.println("Connected...");
            try {
                statement=conn.prepareStatement(sql);
                rs=statement.executeQuery();
                while (rs.next()) {
                    Book bo = new Book();
                    bo.setId(rs.getInt("id"));
                    bo.setCode(rs.getString("code"));
                    bo.setName(rs.getString("name"));
                    bo.setAuthor(rs.getString("author"));
                    bo.setPrice(rs.getDouble("price"));
                    list.add(bo);
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
    public void Insert(Book bo) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql="INSERT INTO book(code,name,author,price) VALUES(?,?,?,?)";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,bo.getCode());
                statement.setString(2,bo.getName());
                statement.setString(3,bo.getAuthor());
                statement.setDouble(4,bo.getPrice());
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
    public void Update(Book bo) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "UPDATE book SET code=?,name=?,author=?,price=? WHERE id=?";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql);
                statement.setString(1,bo.getCode());
                statement.setString(2,bo.getName());
                statement.setString(3,bo.getAuthor());
                statement.setDouble(4,bo.getPrice());
                statement.setInt(5,bo.getId());
                int i = statement.executeUpdate();
                if (i>0) {
                    System.out.println("update success!");
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
    }

    @Override
    public void Delete(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "DELETE FROM book WHERE id=?";
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
    public Book findById(int id) {
        Book bo = new Book();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql= "SELECT * FROM book WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setInt(1,id);
                rs=statement.executeQuery();
                while (rs.next()) {
                    bo.setId(rs.getInt("id"));
                    bo.setCode(rs.getString("code"));
                    bo.setName(rs.getString("name"));
                    bo.setAuthor(rs.getString("author"));
                    bo.setPrice(rs.getDouble("price"));
                }
            } catch (SQLException e) {
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

        return bo;
    }
}