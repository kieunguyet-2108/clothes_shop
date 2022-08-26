/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AminControllers;

import dal.ColorDAO;
import dal.ProductDAO;
import dal.SizeDAO;
import dal.SubCategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Color;
import models.Product;
import models.ProductFilter;
import models.SubCategory;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "products", urlPatterns = {"/admin/products"})
public class products extends HttpServlet {

    private ProductFilter getAllStringParameter(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ProductFilter filter = new ProductFilter();
        String subcategoryId = request.getParameter("subcategoyrid");
        String categoryId = request.getParameter("categoryId");
        String view = request.getParameter("view");
        String page = request.getParameter("page");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");
        String colorId = request.getParameter("colorId");
        String sizeId = request.getParameter("sizeId");
        String sortBy = request.getParameter("sortBy");
        String search = request.getParameter("search");
        try {
            if (categoryId != null) {
                if (!categoryId.equals("all")) {
                    filter.setCategoryId(Integer.parseInt(categoryId));
                }
            }
            if (page != null) {
                filter.setCurrentPage(Integer.parseInt(page));
            }
            if (colorId != null) {
                if (!colorId.equals("all")) {
                    filter.setColorId(Integer.parseInt(colorId));
                }
            }
            if (sizeId != null) {
                if (!sizeId.equals("all")) {
                    filter.setSizeId(Integer.parseInt(sizeId));
                }
            }
            if (subcategoryId != null) {
                filter.setSubcategoryId(Integer.parseInt(subcategoryId));
            }
            if (view != null) {
                filter.setRecordsPerPage(Integer.valueOf(view));
            }
            if (sortBy != null) {
                if (sortBy.equals("priceUp")) {
                    filter.setSortBy("price");
                    filter.setSortMode(true);
                }
                if (sortBy.equals("priceDown")) {
                    filter.setSortBy("price");
                    filter.setSortMode(false);
                }
                if (sortBy.equals("latest")) {
                    filter.setSortBy("date");
                    filter.setSortMode(false);
                }
                if (sortBy.equals("oldest")) {
                    filter.setSortBy("date");
                    filter.setSortMode(true);
                }
            }
            if (search != null) {
                filter.setName(search);
            }
            filter.setMinPrice(Integer.parseInt(minprice));
            filter.setMaxPrice(Integer.parseInt(maxprice));
        } catch (NumberFormatException e) {

        }
        return filter;
    }

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
        SubCategoryDAO sDAO = new SubCategoryDAO();
        ArrayList<SubCategory> subCategories = sDAO.getAllSubCategories();
        request.setAttribute("subcategories", subCategories);
        ProductDAO d = new ProductDAO();
        ProductFilter productFilter = getAllStringParameter(request);
        productFilter.setRecordsPerPage(0);
        ArrayList<Product> products = d.findAllProductByFilter(productFilter);
        String linkParam = "shop?";
        if (request.getQueryString() != null) {
            if (!request.getQueryString().split("page")[0].isEmpty()) {
                linkParam = "shop?" + request.getQueryString().split("&page")[0] + "&";
            }
        }
        productFilter.setTotalResult(d.countAllProductByFilter(productFilter));
        SizeDAO sizeDAO = new SizeDAO();
        ColorDAO colorDAO = new ColorDAO();
        request.setAttribute("minprice", d.getMinPrice());
        request.setAttribute("maxprice", d.getMaxPrice());
        request.setAttribute("colors", colorDAO.getAllColors());
        request.setAttribute("sizes", sizeDAO.getSizes());
        request.setAttribute("linkParam", linkParam);
        request.setAttribute("products", products);
        request.setAttribute("productFilter", productFilter);
        request.getRequestDispatcher("products.jsp").forward(request, response);
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
