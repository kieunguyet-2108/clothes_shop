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
public class Category {
    int CategoryId;
    String CategoryName;

    public Category() {
    }

    public Category(int CategoryId, String CategoryName) {
        this.CategoryId = CategoryId;
        this.CategoryName = CategoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    
}
