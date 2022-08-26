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
import models.Product;
import models.Size;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "cartProcess", urlPatterns = {"/cartProcess"})
public class cartProcess extends HttpServlet {

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
        String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
        HttpSession session = request.getSession();
        ArrayList<Cart> carts = new ArrayList<>();
        if (session.getAttribute("carts") != null) {
            carts = (ArrayList<Cart>) session.getAttribute("carts");
        }
        int productid = Integer.parseInt(request.getParameter("productid"));
        int colorid = Integer.parseInt(request.getParameter("color"));
        int sizeid = Integer.parseInt(request.getParameter("size"));
        if (action.equals("subtract") || action.equals("add") || action.equals("delete")) {
            for (Cart c : carts) {
                if (c.getProduct().getProductId() == productid && c.getColor().getColorId() == colorid
                        && c.getSize().getSizeId() == sizeid) {
                    if (action.equals("subtract")) {
                        if (c.getQuantity() > 1) {
                            c.setQuantity(c.getQuantity() - 1);
                        }
                    }
                    if (action.equals("add")) {
                        if (c.getQuantity() < Pdao.getUnitOfStock(productid, colorid, sizeid)) {
                            c.setQuantity(c.getQuantity() + 1);
                        }
                    }
                    if (action.equals("delete")) {
                        carts.remove(c);
                    }
                }
            }

        }
        if (action.equals("updateProduct")) {
            int newColor = Integer.parseInt(request.getParameter("colorid"));
            int newSize = Integer.parseInt(request.getParameter("sizeid"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            boolean temp = true;
            for (Cart c : carts) {
                if (c.getProduct().getProductId() == productid && c.getColor().getColorId() == newColor
                        && c.getSize().getSizeId() == newSize) {
                    temp = false;
                    c.setQuantity(c.getQuantity() + quantity);
                }
            }
            if (temp) {
                carts.add(new Cart(Pdao.getProduct(String.valueOf(productid)), Sdao.getSizeById(String.valueOf(newSize)),
                        Cdao.getColorById(String.valueOf(newColor)), quantity));
            }
            for (Cart c : carts) {
                if (c.getProduct().getProductId() == productid && c.getColor().getColorId() == colorid
                        && c.getSize().getSizeId() == sizeid) {
                    carts.remove(c);
                }
            }
        }
        session.setAttribute("carts", carts);
        response.sendRedirect("./cart");

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
