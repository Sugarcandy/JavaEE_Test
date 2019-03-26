package servlet;

import Dao.EmployeeDao;
import Impl.EmployeeImpl;
import bean.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chen
 * @create 2019/2/24 0024
 */
@WebServlet("/bean/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        String eno=request.getParameter("eno");
        String repass=request.getParameter("repass");
        PrintWriter out = response.getWriter();

        String message=null;
        if(name==null||name.isEmpty()||pass==null||pass.isEmpty()
                ||eno==null||eno.isEmpty()||repass==null||repass.isEmpty()){
            message="存在信息为空！请检查！";
            out.print("<script>alert('"+message+"');</script>");
            out.print("<a href='/register.jsp'>继续注册</a>");
        }
        else if(!pass.equals(repass)){
            message="两次密码不一致！请检查！";
            out.print("<script>alert('"+message+"');</script>");
            out.print("<a href='/register.jsp'>继续注册</a>");
        }
        else {
            Employee a=new Employee();
            a.setEmpNo(Long.parseLong(eno));
            a.setName(name);
            a.setPassWord(pass);
            EmployeeDao employeeDao=new EmployeeImpl();
            Long result=0L;
            try {
                result = employeeDao.insert(a);
            }catch(Exception e){
                message="插入出错啦，可能出现主键冲突！";
                out.print("<script>alert('" + message+ "');</script>");
                out.print("<a href='/register.jsp'>继续注册</a>");
            }
            if (result > 0) {
                message = "注册成功！";
                out.print("<script>alert('" + message + "');</script>");
                out.print("<a href='/index.jsp'>登录</a>");
            }
        }
    }
}
