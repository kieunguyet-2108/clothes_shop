/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Shipper;

/**
 *
 * @author ADMIN
 */
public class ShipperDAO extends DBContext{
    public ArrayList getAllShippers(){
        ArrayList<Shipper> shippers = new ArrayList<>();
        try {
            String sql = "select * from Shipper";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                shippers.add(new Shipper(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return shippers;
    }
    
    public Shipper getShipperById(String shipperId){
        Shipper shipper = new Shipper();
        try {
            String sql = "select * from Shipper where ShipId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, shipperId);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                shipper = new Shipper(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return shipper;
    }
    
}
