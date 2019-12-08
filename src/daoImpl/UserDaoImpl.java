package daoImpl;

import dao.UserDAO;
import data.ConnectionPool;
import models.Category;
import models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDAO {
    @Override
    public ArrayList<User> findAll(int role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<User> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE role=?";

        if(conn!=null) {
            System.out.println("Connected...");
            try {
                statement = conn.prepareStatement(sql);
                statement.setInt(1,role);
                rs= statement.executeQuery();
                while (rs.next()) {
                    User us = new User();
                    us.setId(rs.getInt("id"));
                    us.setFullName(rs.getString("fullName"));
                    us.setUsername(rs.getString("username"));
                    us.setPassword(rs.getString("password"));
                    us.setAddress(rs.getString("address"));
                    us.setMobile(rs.getString("mobile"));
                    us.setRole(rs.getInt("role"));
                    list.add(us);
                }
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

        return list;
    }

    @Override
    public void Insert(User us) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "INSERT INTO users(username,password,role,mobile,address,fullName) VALUES(?,?,?,?,?,?)";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                conn.setAutoCommit(false);
                statement=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,us.getUsername());
                statement.setString(2,us.getPassword());
                statement.setInt(3,us.getRole());
                statement.setString(4,us.getMobile());
                statement.setString(5,us.getAddress());
                statement.setString(6,us.getFullName());
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
    public void Delete(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "DELETE FROM users WHERE id=?";
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
    public User findById(int id) {
        User us = new User();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE id=?";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement= conn.prepareStatement(sql);
                statement.setInt(1,id);
                rs=statement.executeQuery();
                while (rs.next()) {
                    us.setId(rs.getInt("id"));
                    us.setUsername(rs.getString("username"));
                    us.setPassword(rs.getString("password"));
                    us.setRole(rs.getInt("role"));
                    us.setMobile(rs.getString("mobile"));
                    us.setFullName(rs.getString("fullName"));
                    us.setAddress(rs.getString("address"));
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

        return us;
    }

    @Override
    public User findUser(String username, String password) {
        User us = new User();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                rs = statement.executeQuery();
                while (rs.next()) {
                    us.setId(rs.getInt("id"));
                    us.setUsername(rs.getString("username"));
                    us.setPassword(rs.getString("password"));
                    us.setRole(rs.getInt("role"));
                    us.setMobile(rs.getString("mobile"));
                    us.setFullName(rs.getString("fullName"));
                    us.setAddress(rs.getString("address"));
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
        System.out.println(us);

        return us;
    }

    @Override
    public String findNameUser(String username, String password) {
        String nameUser = "";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT username FROM users WHERE username=? AND password=?";
        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                rs=statement.executeQuery();
                while (rs.next()) {
                    nameUser = rs.getString("username");
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
        System.out.println(nameUser);

        return nameUser;
    }

    @Override
    public User findByUserName(String username) {
        User us = new User();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE username=?";

        if(conn!=null) {
            System.out.println("connected...");
            try {
                statement=conn.prepareStatement(sql);
                statement.setString(1,username);
                rs = statement.executeQuery();
                while (rs.next()) {
                    us.setId(rs.getInt("id"));
                    us.setUsername(rs.getString("username"));
                    us.setPassword(rs.getString("password"));
                    us.setRole(rs.getInt("role"));
                    us.setMobile(rs.getString("mobile"));
                    us.setFullName(rs.getString("fullName"));
                    us.setAddress(rs.getString("address"));
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
        System.out.println(us);

        return us;
    }

}
