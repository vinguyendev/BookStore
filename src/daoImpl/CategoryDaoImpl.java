package daoImpl;

import dao.CategoryDAO;
import data.ConnectionPool;
import models.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDaoImpl implements CategoryDAO {

    @Override
    public ArrayList<Category> findAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM categories";

        if(conn!=null) {
            System.out.println("Connected...");
            try {
                statement=conn.prepareStatement(sql);
                rs =statement.executeQuery();
                while (rs.next()) {
                    Category ca = new Category();
                    ca.setId(rs.getInt("id"));
                    ca.setName(rs.getString("name"));
                    list.add(ca);
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
    public void Insert(Category ca) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "INSERT INTO categories(name) VALUES(?)";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,ca.getName());
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
    public void Update(Category ca) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "UPDATE categories SET name=? WHERE id=?";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement= conn.prepareStatement(sql);
                statement.setString(1,ca.getName());
                statement.setInt(2,ca.getId());
                int i = statement.executeUpdate();
                if(i>0) {
                    System.out.println("updated...");
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
        String sql = "DELETE FROM categories WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql);
                statement.setInt(1,id);
                int i = statement.executeUpdate();
                if(i>0) {
                    System.out.println("deleted...");
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
    public Category findById(int id) {
        Category ca = new Category();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT * FROM categories WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement= conn.prepareStatement(sql);
                statement.setInt(1,id);
                rs=statement.executeQuery();
                while (rs.next()) {
                    ca.setId(rs.getInt("id"));
                    ca.setName(rs.getString("name"));
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
        return ca;
    }

    @Override
    public String getNameCategory(int id) {
        String nameCategory = "";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT name FROM categories WHERE id=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement= conn.prepareStatement(sql);
                statement.setInt(1,id);
                rs=statement.executeQuery();
                nameCategory = rs.getString("name");
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
        return nameCategory;
    }
}
