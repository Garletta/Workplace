package DAO;

import java.sql.*;

public class AccountDao {

    private String Driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/books?characterEncoding=UTF-8";
    private String user = "root";
    private String passwd = "bingjie123";

    public boolean AddAccount(String account,String password,String name) throws Exception {
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection(URL,user,passwd);
        String sql = "select ACCOUNT from T_CUSTOMER where ACCOUNT = '" + account + "'";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()) {
            if(rs != null) rs.close();
            if(stat != null) stat.close();
            if(conn != null) conn.close();
            return false;
        }
        sql = "insert into T_CUSTOMER (ACCOUNT, PASSWORD, CNAME) value (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,account);
        ps.setString(2,password);
        ps.setString(3,name);
        ps.executeUpdate();
        if(ps != null) ps.close();
        if(rs != null) rs.close();
        if(stat != null) stat.close();
        if(conn != null) conn.close();
        return true;
    }

    public boolean queryAccount(String account, String password) throws Exception{
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection(URL,user,passwd);
        String sql = "select ACCOUNT from T_CUSTOMER where ACCOUNT = ? and PASSWORD = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,account);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
            return true;
        } else {
            return false;
        }
    }
}
