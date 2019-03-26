package servlet;

import bean.Cart;
import bean.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author chen
 * @create 2019/3/21 0021
 */
@WebServlet("/bean/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");//获取购物车
        if(cart==null)//如果购物车是空的，就创建一个购物车
            cart=new Cart();
        String productId=request.getParameter("productId");
        cart.addToCart(productId);//加入购物车
        List<CartItem> list=cart.getList();
        session.setAttribute("prolist",list);
        session.setAttribute("cart",cart);
        response.sendRedirect("/bean/ProductServlet");
    }
}