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

@WebServlet(name = "searchBooksByNameServlet")
public class searchBooksByNameServlet extends HttpServlet {

    private String Driver;
    private String URL;
    private String UserName;
    private String Password;

    public void init() throws ServletException {
        Driver = this.getInitParameter("DriverClassName");
        URL = this.getInitParameter("URL");
        UserName = this.getInitParameter("UserName");
        Password = this.getInitParameter("Password");
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String keyWord = request.getParameter("bookName");
        HttpSession session = request.getSession();
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=UTF-8","root","bingjie123");
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL,UserName,Password);
            String sql = "select BOOKID,BOOKNAME,BOOKPRICE from T_BOOK where BOOKNAME like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + keyWord + "%");
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<>();
            while(rs.next()) {
                Book book = new Book();
                book.setBOOKID(rs.getString(1));
                book.setBOOKNAME(rs.getString(2));
                book.setBOOKPRICE(rs.getDouble(3));
                books.add(book);
            }
            rs.close();
            ps.close();
            conn.close();
            session.setAttribute("books",books);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/showBooks.jsp");
            rd.forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
