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
public class SubCategory {
    int SubCategoryId;
    String SubCategoryName;
    String Description;
    Category category;

    public SubCategory() {
    }

    public SubCategory(int SubCategoryId, String SubCategoryName, String Description) {
        this.SubCategoryId = SubCategoryId;
        this.SubCategoryName = SubCategoryName;
        this.Description = Description;
    }

    public int getSubCategoryId() {
        return SubCategoryId;
    }

    public void setSubCategoryId(int SubCategoryId) {
        this.SubCategoryId = SubCategoryId;
    }

    public String getSubCategoryName() {
        return SubCategoryName;
    }

    public void setSubCategoryName(String SubCategoryName) {
        this.SubCategoryName = SubCategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(int id , String name) {
        Category c = new Category(id, name);
        this.category = c;
    }
    
    
}
