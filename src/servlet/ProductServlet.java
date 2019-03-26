package servlet;

import Dao.ProductDao;
import Impl.ProductImpl;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author chen
 * @create 2019/3/21 0021
 */
@WebServlet("/bean/ProductServlet")
public class ProductServlet extends HttpServlet {

    static ProductDao productDao=new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        List<Product> list=productDao.load();//获取产品列表
        request.setAttribute("list",list);
        request.getRequestDispatcher("/success.jsp").forward(request,response);

    }
}
