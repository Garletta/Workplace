package DAO;

import java.sql.*;

public class RegisterDao {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/books?characterEncoding=UTF-8";
    private String user = "root";
    private String passwd = "bingjie123";

    public boolean confirmRegister(String account, String password, String name) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,user,passwd);
        String sql = "select * from T_CUSTOMER where ACCOUNT = '" + account + "'";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        if(rs.next()) {
            return false;
        }

        sql = "insert into T_CUSTOMER (ACCOUNT, PASSWORD, CNAME) value (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,account);
        ps.setString(2,password);
        ps.setString(3,name);
        ps.executeUpdate();

        stat.close();
        rs.close();
        ps.close();
        conn.close();
        return true;
    }
}
