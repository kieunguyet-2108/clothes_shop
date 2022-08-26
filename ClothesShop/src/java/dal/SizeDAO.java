/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Size;

/**
 *
 * @author ADMIN
 */
public class SizeDAO extends DBContext {

    public ArrayList getSizes() {
        ArrayList<Size> sizes = new ArrayList<>();
        try {
            String sql = "select * from Size";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sizes.add(new Size(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return sizes;
    }

    public ArrayList getSizesByProductId(String productId) {
        ArrayList<Size> sizes = new ArrayList<>();
        try {
            String sql = "select s.SizeId , s.Size \n"
                    + "from Product_Options p , Size s\n"
                    + "where p.SizeId = s.SizeId and p.ProductId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, productId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                sizes.add(new Size(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return sizes;
    }

    public Size getSizeById(String sizeId){
        try {
            String sql = "select * from Size where SizeId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sizeId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return new Size(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }
}
