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
import models.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO extends DBContext {

    public ArrayList getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "select * from Category ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return categories;
    }

}
