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

@WebServlet(name = "deleteCartServlet")
public class deleteCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ArrayList<Book> carts = (ArrayList<Book>) session.getAttribute("carts");
        if(carts == null) {
            carts = new ArrayList<>();
        }
        String BOOKID = request.getParameter("BOOKID");
        for(int i = 0;i < carts.size();i++) {
            if(carts.get(i).getBOOKID().equals(BOOKID)) {
                carts.remove(i);
                break;
            }
        }
        session.setAttribute("carts",carts);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsps/showCart.jsp");
        rd.forward(request,response);
    }
}
