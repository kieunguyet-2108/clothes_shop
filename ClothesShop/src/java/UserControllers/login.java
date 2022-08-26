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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    UserDAO Udao = new UserDAO();

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
        String forAction = (request.getParameter("for") == null) ? "" : request.getParameter("for");
        System.out.println(request.getQueryString());
        request.setAttribute("queryString", request.getQueryString());
        request.setAttribute("forAction", forAction);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        boolean isUser = true;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String mess = "";
            User user = Udao.getUser(email, password);
            if (user == null) {
                mess = "Sai tài khoản hoặc mật khẩu. Vui lòng nhập lại";
                request.setAttribute("email", email);
                request.setAttribute("message", mess);
                processRequest(request, response);
            } else {
                if (request.getParameter("remember") != null && request.getParameter("remember").equals("on")) {
                    isUser = false;
                    Cookie cookieSelector = new Cookie("uid", String.valueOf(user.getUserId()));
                    cookieSelector.setMaxAge(604800);
                    Cookie cookieValidator = new Cookie("uname", user.getEmail());
                    cookieValidator.setMaxAge(604800);
                    response.addCookie(cookieSelector);
                    response.addCookie(cookieValidator);
                }
            }
            String forAction = (request.getParameter("for") == null) ? "" : request.getParameter("for");
            if (isUser) {
                session.setAttribute("userLogin", user);
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
                    System.out.println(request.getQueryString());
                    ArrayList<Cart> carts = new ArrayList<>();
                    carts = (ArrayList<Cart>) session.getAttribute("carts");
                    request.setAttribute("queryString", request.getQueryString());
                    request.setAttribute("listOrders", carts);
                    request.getRequestDispatcher("Checkout.jsp").forward(request, response);
                }

            }
        } catch (IOException | ServletException e) {
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
