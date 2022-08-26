/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AminControllers;

//import com.google.gson.Gson;
import com.google.gson.Gson;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "api", urlPatterns = {"/admin/api"})
public class api extends HttpServlet {

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
        response.setContentType("application/json; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        ProductDAO productDAO = new ProductDAO();
        String action = request.getParameter("action");
        if (action.equals("view")) {
            response.getWriter().write(gson.toJson(productDAO.findProductById(request.getParameter("id"))));
        }
        if (action.equals("delete")) {
            if (productDAO.deleteProduct(Integer.parseInt(request.getParameter("id")))) {
                response.getWriter().write(gson.toJson("success"));
            } else {
                response.getWriter().write(gson.toJson("failed"));
            }
        }
        if (action.equals("update")) {
            String productName = request.getParameter("productName");
            String id = request.getParameter("id");
            String productImage = request.getParameter("productImage");
            String unitPrice = request.getParameter("unitPrice");
            String description = request.getParameter("description");
            String subcategory = request.getParameter("categoryId");
            String[] colorId = request.getParameterValues("colorId");
            String[] sizeId = request.getParameterValues("sizeId");
            String[] quantity = request.getParameterValues("quantity");
            if (productDAO.updateProduct(Integer.parseInt(id), productName, description, productImage, Integer.parseInt(unitPrice), Integer.parseInt(subcategory), colorId, sizeId, quantity)) {
                response.sendRedirect("products");
            } else {
                response.getWriter().write(gson.toJson("failed"));
            }
        }
        if (action.equals("add")) {
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String unitPrice = request.getParameter("unitPrice");
            String description = request.getParameter("description");
            String subcategory = request.getParameter("categoryId");
            String[] colorId = request.getParameterValues("colorId");
            String[] sizeId = request.getParameterValues("sizeId");
            String[] quantity = request.getParameterValues("quantity");
            if (productDAO.insertProduct(productName, description, productImage, Integer.parseInt(unitPrice), Integer.parseInt(subcategory), colorId, sizeId, quantity)) {
                response.sendRedirect("products");
            } else {
                response.getWriter().write(gson.toJson("failed"));
            }
        }
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
