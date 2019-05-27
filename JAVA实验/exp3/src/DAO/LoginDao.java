package DAO;

import java.sql.*;

public class LoginDao {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/books?characterEncoding=UTF-8";
    private String user = "root";
    private String passwd = "bingjie123";

    public String queryAccount(String account, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,user,passwd);
        String sql = "select * from T_CUSTOMER where ACCOUNT = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,account);
        ResultSet rs = ps.executeQuery();
        String ans = null;
        while(rs.next()) {
            String pw = rs.getString(2);
            String na = rs.getString(3);
            ans = "-1";
            if(pw.equals(password)) {
                ans = na;
                break;
            }
        }
        rs.close();
        ps.close();
        conn.close();
        return ans;
    }
}
