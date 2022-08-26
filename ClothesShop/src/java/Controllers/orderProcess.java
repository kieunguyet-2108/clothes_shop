/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import dal.OrderDAO;
import dal.ProductDAO;
import dal.ShipperDAO;
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
import models.Shipper;
import models.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "orderProcess", urlPatterns = {"/orderProcess"})
public class orderProcess extends HttpServlet {
    
    ShipperDAO Sdao = new ShipperDAO();
    OrderDAO Odao = new OrderDAO();
    ProductDAO Pdao = new ProductDAO();

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String forAction = (request.getParameter("for") == null) ? "" : request.getParameter("for");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String orderdate = request.getParameter("orderdate");
        String shipdate = request.getParameter("shipdate");
        User user = new User();
        if (session.getAttribute("userLogin") != null) {
            user = (User) session.getAttribute("userLogin");
        }
        Shipper shipper = Sdao.getShipperById(request.getParameter("shipUnit"));
        int oderId = Odao.insertIntoOrder(user, name, address, email, phone, orderdate, shipdate, shipper);
        if (forAction.equals("product_order")) {
            Product p = Pdao.getProduct(request.getParameter("productid"));
            int colorid = Integer.parseInt(request.getParameter("colorid"));
            int sizeid = Integer.parseInt(request.getParameter("sizeid"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Odao.insertIntoOrderDetail(oderId, p.getProductId(), quantity);
            Pdao.updateQuantity(Pdao.getUnitOfStock(p.getProductId(), colorid, sizeid), quantity, p.getProductId(), colorid, sizeid);
        }
        if (forAction.equals("carts_order")) {
            ArrayList<Cart> carts = (ArrayList<Cart>) session.getAttribute("carts");
            for (Cart c : carts) {
                Odao.insertIntoOrderDetail(oderId, c.getProduct().getProductId(), c.getQuantity());
                Pdao.updateQuantity(Pdao.getUnitOfStock(c.getProduct().getProductId(), c.getColor().getColorId(), c.getSize().getSizeId()),
                        c.getQuantity(), c.getProduct().getProductId(), c.getColor().getColorId(), c.getSize().getSizeId());
            }
        }
        response.sendRedirect("./home");
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
