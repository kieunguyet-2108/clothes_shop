/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Benjamin
 */
public class OrderDetails {

    int orderId;
    int productId;
    int quantity;
    String productName;
    int totalMoney;

    public OrderDetails() {
    }

    public OrderDetails(int orderId, int productId, int quantity, String productName, int totalMoney) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.totalMoney = totalMoney;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

}
