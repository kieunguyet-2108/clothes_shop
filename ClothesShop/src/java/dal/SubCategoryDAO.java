/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.SubCategory;

/**
 *
 * @author ADMIN
 */
public class SubCategoryDAO extends DBContext {

    public ArrayList getAllSubCategories() {
        ArrayList<SubCategory> subcategories = new ArrayList<>();
        try {
            String sql = "select s.* , c.CategoryName \n"
                    + " from SubCategory s , Category c where s.CategoryId = c.CategoryId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SubCategory sub = new SubCategory(rs.getInt(1),
                        rs.getString(2), rs.getString(3));
                sub.setCategory(rs.getInt(4), rs.getString(5));
                subcategories.add(sub);
            }
        } catch (SQLException e) {
        }
        return subcategories;
    }

    public SubCategory getSubById(int productid) {
        SubCategory sub = new SubCategory();
        try {
            String sql = "select s.*\n"
                    + "from SubCategory s , Product p\n"
                    + "where p.ProductId = ? and s.SubcategoryId = p.SubcategoryId";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               sub =  new SubCategory(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return sub;
    }

}
