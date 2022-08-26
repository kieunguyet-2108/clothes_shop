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
import java.util.HashMap;
import java.util.Map;
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

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "product_details", urlPatterns = {"/product_details"})
public class product_details extends HttpServlet {

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
        String productid = (request.getParameter("productid") == null) ? "" : request.getParameter("productid");
        Product product = Pdao.getProduct(productid);
        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", Pdao.getProductsBySC(product.getSubcategory().getSubCategoryId()));
        request.getRequestDispatcher("Product.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");

        try {
            String productId = request.getParameter("productid");
            Product product = Pdao.getProduct(productId);
            Color color = Cdao.getColorById(request.getParameter("color"));
            Size size = Sdao.getSizeById(request.getParameter("size"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (action.equals("Add to cart")) {
                Cart cart = new Cart(product, size, color, quantity);
                ArrayList<Cart> carts = new ArrayList<>();
                if (session.getAttribute("carts") == null) {
                    carts.add(cart);
                } else {
                    carts = (ArrayList<Cart>) session.getAttribute("carts");
                    boolean temp = false;
                    for (Cart c : carts) {
                        if (c.getProduct().getProductId() == cart.getProduct().getProductId() && c.getColor().getColorId() == cart.getColor().getColorId()
                                && c.getSize().getSizeId() == cart.getSize().getSizeId()) {
                            temp = true;
                            c.setQuantity(c.getQuantity() + quantity);
                        }
                    }
                    if (!temp) {
                        carts.add(cart);
                    }
                }
                session.setAttribute("carts", carts);
                response.sendRedirect("./product_details?productid=" + productId);
            }
            if (action.equals("Order now")) {
                if (session.getAttribute("userLogin") == null) {
                    response.sendRedirect("./login?for=product_order&productid=" + productId
                            + "&colorid=" + color.getColorId() + "&sizeid=" + size.getSizeId() + "&quantity=" + quantity);
                } else {
                    response.sendRedirect("./order?for=product_order&productid=" + productId
                            + "&colorid=" + color.getColorId() + "&sizeid=" + size.getSizeId() + "&quantity=" + quantity);
                }
            }

        } catch (Exception e) {
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
