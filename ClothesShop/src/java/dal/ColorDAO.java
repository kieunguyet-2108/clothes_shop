/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Color;

/**
 *
 * @author ADMIN
 */
public class ColorDAO extends DBContext {

    public ArrayList getAllColors() {
        ArrayList<Color> colors = new ArrayList<>();
        try {
            String sql = "select * from Color ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                colors.add(new Color(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return colors;
    }

    public ArrayList getColorsById(String productId) {
        ArrayList<Color> colors = new ArrayList<>();
        try {
            String sql = "select distinct c.ColorId , c.Color\n"
                    + "from Product_Options p , Color c\n"
                    + "where p.ColorId = c.ColorId and p.ProductId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, productId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                colors.add(new Color(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return colors;
    }
    
    
    public Color getColorById(String colorId){
        try {
            String sql = "select * from Color where ColorId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, colorId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return new Color(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
