package servlets;

import beans.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "addCartServlet")
public class addCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String BOOKID = request.getParameter("BOOKID");
        HttpSession session = request.getSession();
        ArrayList<Book> carts = (ArrayList<Book>) session.getAttribute("carts");
        if(carts == null) {
            carts = new ArrayList<>();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=UTF-8","root","bingjie123");
            String sql = "select BOOKID,BOOKNAME,BOOKPRICE from T_BOOK where BOOKID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,BOOKID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setBOOKID(rs.getString("BOOKID"));
                book.setBOOKNAME(rs.getString("BOOKNAME"));
                book.setBOOKPRICE(rs.getDouble("BOOKPRICE"));
                carts.add(book);
            }
            rs.close();
            ps.close();
            conn.close();
            session.setAttribute("carts",carts);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/showBooks.jsp");
            rd.forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
