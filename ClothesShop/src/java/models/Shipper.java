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
public class Shipper {
    int ShipId;
    String ShipName;

    public Shipper() {
    }

    public Shipper(int ShipId, String ShipName) {
        this.ShipId = ShipId;
        this.ShipName = ShipName;
    }

    public int getShipId() {
        return ShipId;
    }

    public void setShipId(int ShipId) {
        this.ShipId = ShipId;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String ShipName) {
        this.ShipName = ShipName;
    }
    
    
}
