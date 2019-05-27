package servlets;

import DAO.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        LoginDao loginDao = new LoginDao();
        try {
            String name = loginDao.queryAccount(account,password);
            if(name == null) {
                pw.println("登陆失败,账号不存在!");
            } else if(name.equals("-1")) {
                pw.println("登陆失败,密码错误！");
            } else {
                pw.println("登陆成功,欢迎" + name + "!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
