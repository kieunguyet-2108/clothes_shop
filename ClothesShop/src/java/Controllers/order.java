/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import dal.ColorDAO;
import dal.ProductDAO;
import dal.SizeDAO;
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
@WebServlet(name = "order", urlPatterns = {"/order"})
public class order extends HttpServlet {

    ProductDAO Pdao = new ProductDAO();
    ColorDAO Cdao = new ColorDAO();
    SizeDAO Sdao = new SizeDAO();

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
        HttpSession session = request.getSession();
        String forAction = (request.getParameter("for") == null) ? "" : request.getParameter("for");
        ArrayList<Cart> orderList = new ArrayList<>();
        String queryString = "";
        if (forAction.equals("product_order")) {
            Product product = Pdao.getProduct(request.getParameter("productid"));
            Color color = Cdao.getColorById(request.getParameter("color"));
            Size size = Sdao.getSizeById(request.getParameter("size"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            orderList.add(new Cart(product, size, color, quantity));
            queryString = request.getQueryString();
        }
        if (forAction.equals("carts_order")) {
            orderList = (ArrayList<Cart>) session.getAttribute("carts");
            queryString = request.getQueryString();
        }
        request.setAttribute("queryString", queryString);
        request.setAttribute("listOrders", orderList);
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
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
        processRequest(request, response);
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
