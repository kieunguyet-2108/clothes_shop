/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Order;
import models.Shipper;
import models.User;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext {

    public int insertIntoOrder(User u, String name, String address, String email, String phone, String orderDate, String shipDate, Shipper shipper) {
        int orderId = 0;
        try {
            String sql = "insert into dbo.[Order](UserId,Name,ShipAdress,Email,PhoneNumber,OrderDate,ShipDate,ShipId)\n"
                    + "output inserted.OrderId\n"
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, u.getUserId());
            stm.setNString(2, name);
            stm.setNString(3, address);
            stm.setString(4, email);
            stm.setString(5, phone);
            stm.setString(6, orderDate);
            stm.setString(7, shipDate);
            stm.setInt(8, shipper.getShipId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                orderId = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return orderId;
    }

    public void insertIntoOrderDetail(int orderId, int productId, int quantity) {
        try {
            String sql = "insert into dbo.[Order Detail](OrderId,ProductId,Quantity,Discount)\n"
                    + "values (?,?,?,0)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            stm.setInt(2, productId);
            stm.setInt(3, quantity);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Order> findAllOrder() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "select * from [Order] order by OrderDate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderId(rs.getInt(1));
                o.setName(rs.getString(3));
                o.setShipAddress(rs.getString(4));
                o.setEmail(rs.getString(5));
                o.setPhoneNumber(rs.getString(6));
                o.setOrderDate(rs.getDate(7).toString());
                o.setShipDate(rs.getDate(8).toString());
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    }
}
