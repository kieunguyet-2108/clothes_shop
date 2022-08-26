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
public class ProductFilter {

    private int subcategoryId;
    private int categoryId;
    private int minPrice;
    private int maxPrice;
    private int currentPage;
    private int recordsPerPage;
    private int totalPage;
    private int totalResult;
    private int productId;
    private String sortBy;
    private boolean sortMode;
    private int colorId;
    private int sizeId;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProductFilter() {
        this.minPrice = 0;
        this.sizeId = 0;
        this.colorId = 0;
        this.currentPage = 1;
        this.recordsPerPage = 18;
        this.categoryId = 0;
        this.subcategoryId = 0;
        this.sortBy = "";
        this.sortMode = true;
        this.productId = 0;
        this.name = "";

    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getColorId() {
        return colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getTotalPage() {
        int total = totalResult / recordsPerPage;
        if (totalResult % recordsPerPage != 0) {
            total += 1;
        }
        return total;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isSortMode() {
        return sortMode;
    }

    public void setSortMode(boolean sortMode) {
        this.sortMode = sortMode;
    }

}
