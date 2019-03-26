package servlet;

import Dao.EmployeeDao;
import Impl.EmployeeImpl;
import bean.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chen
 * @create 2019/3/14 0014
 */
@WebServlet("/bean/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String user=request.getParameter("user");
        String pass=request.getParameter("password");
        String remmber=request.getParameter("remeber");
        HttpSession session=request.getSession();

        PrintWriter out = response.getWriter();


        EmployeeDao employeeDao=new EmployeeImpl();
        Employee employee=employeeDao.loadbyNo(user);
        session.setAttribute("username",employee.getName());
        String message=null;
        if(pass.equals(employee.getPassWord())){
            message="登录成功！";
            out.print("<script>alert('"+message+"');</script>");
            if(remmber!=null){
                //记住密码:生成新的cookie用来保存账号密码
                Cookie userId = new Cookie("userId", user);
                userId.setMaxAge(1296000);
                Cookie password = new Cookie("password", pass);
                userId.setMaxAge(1296000);
                response.addCookie(userId);
                response.addCookie(password);
            }
            response.sendRedirect("/bean/ProductServlet");

        }else {
            message="登录失败！请检查！";
            out.print("<script>alert('"+message+"');</script>");
            response.sendRedirect("/success.jsp");
        }
    }
}
