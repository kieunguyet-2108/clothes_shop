/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Order {
   int OrderId;
   User user;
   String Name;
   String ShipAddress;
   String Email;
   String PhoneNumber;
   String OrderDate;
   String ShipDate;
   Shipper shipper;

    public Order() {
    }

    public Order(int OrderId, User user, String Name, String ShipAddress, String Email, String PhoneNumber, String OrderDate, String ShipDate, Shipper shipper) {
        this.OrderId = OrderId;
        this.user = user;
        this.Name = Name;
        this.ShipAddress = ShipAddress;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.OrderDate = OrderDate;
        this.ShipDate = ShipDate;
        this.shipper = shipper;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String ShipAddress) {
        this.ShipAddress = ShipAddress;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getShipDate() {
        return ShipDate;
    }

    public void setShipDate(String ShipDate) {
        this.ShipDate = ShipDate;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
    
}
