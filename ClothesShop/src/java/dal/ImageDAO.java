/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Image;

/**
 *
 * @author ADMIN
 */
public class ImageDAO extends DBContext {

    public ArrayList getImages(int productid) {
        ArrayList<Image> images = new ArrayList<>();
        try {
            String sql = "select * from Image\n"
                    + "where ProductId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                images.add(new Image(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return images;
    }

}
