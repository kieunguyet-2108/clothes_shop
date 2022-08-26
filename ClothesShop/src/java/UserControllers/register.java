/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserControllers;

import dal.ColorDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.Color;
import models.Product;
import models.Size;
import models.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
  ProductDAO Pdao = new ProductDAO();
    ColorDAO Cdao = new ColorDAO();
    SizeDAO Sdao = new SizeDAO();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        UserDAO d = new UserDAO();
        User u = new User();
        boolean isUser = true;
        if (d.checkEmailExit(email) != 0) {
            isUser = false;
            request.setAttribute("message", "Tài khoản đã tồn tại");
            processRequest(request, response);
            return;
        }
        if (!password.equals(re_password)) {
            isUser = false;
            request.setAttribute("message", "Mật khẩu nhập lại không khớp");
            processRequest(request, response);
        } else {
            if (d.insertUser(email, password)) {
                isUser = true;
                u =  d.getUser(email, password);
            }
        }
        
         String forAction = (request.getParameter("for") == null) ? "" : request.getParameter("for");
            if (isUser) {
                session.setAttribute("userLogin", u);
                if (forAction.equals("")) {
                    response.sendRedirect("./home");
                }
                if (forAction.equals("product_order")) {
                    Product p = Pdao.getProduct(request.getParameter("productid"));
                    Color color = Cdao.getColorById(request.getParameter("color"));
                    Size size = Sdao.getSizeById(request.getParameter("size"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Cart> carts = new ArrayList<>();
                    carts.add(new Cart(p, size, color, quantity));
                    request.setAttribute("queryString", request.getQueryString());
                    request.setAttribute("listOrders", carts);
                    request.getRequestDispatcher("Checkout.jsp").forward(request, response);
                }
                if (forAction.equals("carts_order")) {
                    ArrayList<Cart> carts = new ArrayList<>();
                    carts = (ArrayList<Cart>) session.getAttribute("carts");
                    request.setAttribute("queryString", request.getQueryString());
                    request.setAttribute("listOrders", carts);
                    request.getRequestDispatcher("Checkout.jsp").forward(request, response);
                }

            }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
