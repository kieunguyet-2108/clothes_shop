/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Product;
import models.ProductFilter;
import models.ProductOption;
import models.SubCategory;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    ColorDAO Cdao = new ColorDAO();
    SizeDAO Sdao = new SizeDAO();
    ImageDAO Idao = new ImageDAO();
    SubCategoryDAO SCdao = new SubCategoryDAO();

    public boolean deleteProduct(int productId) {
        try {
            String sql = "delete from Product_Options\n"
                    + "where ProductId = ?\n"
                    + "delete from [Image]\n"
                    + "where ProductId = ?\n"
                    + "delete from Product \n"
                    + "where ProductId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            stm.setInt(2, productId);
            stm.setInt(3, productId);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateProduct(int productId, String name, String des, String image, int unitprice, int sub, String[] color, String[] size, String[] quantity) {
        try {
            String sql = "delete from Product_Options\n"
                    + "where ProductId = ?\n"
                    + "update Product\n"
                    + "set ProductName = ?,[Product Description] = ?, ProductImage = ?, SubcategoryId = ?,\n"
                    + "[Unit Price] = ?\n"
                    + "where ProductId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            stm.setNString(2, name);
            stm.setNString(3, des);
            stm.setString(4, image);
            stm.setInt(5, sub);
            stm.setInt(6, unitprice);
            stm.setInt(7, productId);
            stm.executeUpdate();
            String sql2 = "insert into Product_Options (ProductId, ColorId, SizeId, Quantity)\n"
                    + "values (?,?,?,?)";
            stm = connection.prepareStatement(sql2);
            for (int i = 0; i < color.length; i++) {
                stm.setInt(1, productId);
                stm.setInt(2, Integer.parseInt(color[i].trim()));
                stm.setInt(3, Integer.parseInt(size[i].trim()));
                stm.setInt(4, Integer.parseInt(quantity[i].trim()));
                stm.executeUpdate();
            }
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean insertProduct(String name, String des, String image, int unitprice, int sub, String[] color, String[] size, String[] quantity) {
        try {
            String sql = "insert into Product (ProductName, ProductImage, [Unit Price], [Product Description], SubcategoryId)\n"
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setNString(1, name);
            stm.setString(2, image);
            stm.setInt(3, unitprice);
            stm.setNString(4, des);
            stm.setInt(5, sub);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            int pid = 0;
            while (rs.next()) {
                pid = rs.getInt(1);
            }
            String sql2 = "insert into Product_Options (ProductId, ColorId, SizeId, Quantity)\n"
                    + "values (?,?,?,?)";
            PreparedStatement stm1 = connection.prepareStatement(sql2);
            for (int i = 0; i < color.length; i++) {
                stm1.setInt(1, pid);
                stm1.setInt(2, Integer.parseInt(color[i].trim()));
                stm1.setInt(3, Integer.parseInt(size[i].trim()));
                stm1.setInt(4, Integer.parseInt(quantity[i].trim()));
                stm1.executeUpdate();
            }
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public void updateQuantity(int oldQuantity, int quantity, int productid, int colorid, int sizeid) {
        try {
            String sql = "update dbo.Product_Options\n"
                    + "set Quantity = ? \n"
                    + "where ProductId = ? and ColorId = ? and SizeId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, oldQuantity - quantity);
            stm.setInt(2, productid);
            stm.setInt(3, colorid);
            stm.setInt(4, sizeid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getUnitOfStock(int productId, int colorId, int sizeId) {
        int num = 0;
        try {
            String sql = "select Quantity from Product_Options\n"
                    + "where ProductId = ? AND ColorId = ? AND SizeId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            stm.setInt(2, colorId);
            stm.setInt(3, sizeId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return num;
    }

    public Product getProduct(String productid) {
        Product product = new Product();
        try {
            String sql = "select * from Product where ProductId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, productid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5));
                product.setSubcategory(SCdao.getSubById(product.getProductId()));
                product.setColors(Cdao.getColorsById(String.valueOf(product.getProductId())));
                product.setImages(Idao.getImages(rs.getInt(1)));
                product.setSizes(Sdao.getSizesByProductId(String.valueOf(rs.getInt(1))));
            }
        } catch (Exception e) {
        }
        return product;
    }

    public Product findProductById(String productid) {
        Product product = new Product();
        ArrayList<ProductOption> options = new ArrayList<>();
        try {
            String sql = "select * from Product where ProductId = ? ";
            String sql2 = "select po.ColorId,c.Color,po.SizeId,s.Size,po.Quantity\n"
                    + "from Product p, Product_Options po, Color c, Size s\n"
                    + "where po.ColorId = c.ColorId and s.SizeId = po.SizeId and po.ProductId = p.ProductId\n"
                    + "and p.ProductId = ?";

            PreparedStatement stm2 = connection.prepareStatement(sql2);
            stm2.setInt(1, Integer.parseInt(productid));
            ResultSet rs2 = stm2.executeQuery();
            while (rs2.next()) {
                options.add(new ProductOption(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getString(4), rs2.getInt(5)));
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, productid);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5));
                product.setSubcategory(SCdao.getSubById(product.getProductId()));
                product.setImages(Idao.getImages(rs.getInt(1)));
                product.setProductOptions(options);
            }
        } catch (Exception e) {
        }
        return product;
    }

    public ArrayList getProducts(int categoryid) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select p.* , s.SubCategoryName , s.CategoryId , c.CategoryName\n"
                    + "from Product p , Category c , SubCategory s\n"
                    + "where p.SubcategoryId = s.SubcategoryId and s.CategoryId = c.CategoryId and c.CategoryId = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5));
                product.setSubcategory(SCdao.getSubById(product.getProductId()));
                product.setColors(Cdao.getColorsById(String.valueOf(product.getProductId())));
                product.setImages(Idao.getImages(rs.getInt(1)));
                product.setSizes(Sdao.getSizesByProductId(String.valueOf(product.getProductId())));
                products.add(product);

            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList getProductsBySC(int subcategoryid) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select p.*\n"
                    + "from Product p \n"
                    + "where p.SubcategoryId  = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, subcategoryid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5));
                product.setSubcategory(SCdao.getSubById(product.getProductId()));
                product.setColors(Cdao.getColorsById(String.valueOf(product.getProductId())));
                product.setImages(Idao.getImages(rs.getInt(1)));
                product.setSizes(Sdao.getSizesByProductId(String.valueOf(product.getProductId())));
                products.add(product);

            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> findAllProductByFilter(ProductFilter filter) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            int colorId = filter.getColorId();
            int sizeId = filter.getSizeId();
            int categoryId = filter.getCategoryId();
            int minPrice = filter.getMinPrice();
            int maxPrice = filter.getMaxPrice();
            int productId = filter.getProductId();
            String sortBy = filter.getSortBy();
            String sql = "select * from Product p, SubCategory s " + (categoryId != 0 ? ", Category c " : "")
                    + ((sizeId != 0 || colorId != 0 || sortBy.equals("quantity")) ? ", Product_Options po " : "")
                    + "where p.SubcategoryId = s.SubcategoryId " + (filter.getSubcategoryId() != 0 ? " and p.SubcategoryId = ? " : "") + (categoryId != 0 ? " and c.CategoryId = s.CategoryId and c.CategoryId = ? " : "")
                    + ((sizeId != 0 || colorId != 0) ? " and po.ProductId = p.ProductId " : "") + (productId != 0 ? " and p.ProductId = ? " : "")
                    + (sizeId != 0 ? " and po.SizeId = ? " : "") + (colorId != 0 ? " and po.ColorId = ? " : "")
                    + (!filter.getName().isEmpty() ? " and p.ProductName like ? " : "")
                    + ((minPrice != 0 && maxPrice != 0 && minPrice < maxPrice) ? " and p.[Unit Price] between ? and ? \n" : "")
                    + (sortBy.equals("price") ? " order by p.[Unit Price] " : sortBy.equals("date") ? " order by p.createdTime " : sortBy.equals("quantity") ? " order by po.Quantity " : "  order by p.ProductId ")
                    + (filter.isSortMode() ? " ASC\n" : " DESC\n")
                    + (filter.getRecordsPerPage() != 0 ? "offset (?-1)*? rows fetch next ? rows only" : "");
            int index = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            if (filter.getSubcategoryId() != 0) {
                stm.setInt(index, filter.getSubcategoryId());
                index++;
            }
            if (categoryId != 0) {
                stm.setInt(index, categoryId);
                index++;
            }
            if (productId != 0) {
                stm.setInt(index, productId);
                index++;
            }
            if (sizeId != 0) {
                stm.setInt(index, sizeId);
                index++;
            }
            if (colorId != 0) {
                stm.setInt(index, colorId);
                index++;
            }
            if (!filter.getName().isEmpty()) {
                stm.setNString(index, "%" + filter.getName() + "%");
                index++;
            }
            if (minPrice != 0 && maxPrice != 0 && minPrice < maxPrice) {
                stm.setInt(index, minPrice);
                stm.setInt(index + 1, maxPrice);
                index += 2;
            }
            if (filter.getRecordsPerPage() != 0) {
                stm.setInt(index, filter.getCurrentPage());
                stm.setInt(index + 1, filter.getRecordsPerPage());
                stm.setInt(index + 2, filter.getRecordsPerPage());
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setProductImage(rs.getString(3));
                p.setUnitPrice(rs.getInt(4));
                p.setProductDescription(rs.getString(5));
                p.setCreatedTime(rs.getDate(7));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;
    }

    public int getMinPrice() {
        try {
            String sql = "select min(p.[Unit Price]) from Product p";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getMaxPrice() {
        try {
            String sql = "select max(p.[Unit Price]) from Product p";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public boolean checkProductOption(int productId) {
        try {
            String sql = "select count(*) from Product_Options where ProductId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1) != 0;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int countAllProductByFilter(ProductFilter filter) {
        try {
            int colorId = filter.getColorId();
            int sizeId = filter.getSizeId();
            int categoryId = filter.getCategoryId();
            int minPrice = filter.getMinPrice();
            int maxPrice = filter.getMaxPrice();
            int productId = filter.getProductId();
            String sortBy = filter.getSortBy();
            String sql = "select count(*) from Product p, SubCategory s " + (categoryId != 0 ? ", Category c " : "")
                    + ((sizeId != 0 || colorId != 0 || sortBy.equals("quantity")) ? ", Product_Options po " : "")
                    + "where p.SubcategoryId = s.SubcategoryId " + (filter.getSubcategoryId() != 0 ? " and p.SubcategoryId = ? " : "") + (categoryId != 0 ? " and c.CategoryId = s.CategoryId and c.CategoryId = ? " : "")
                    + ((sizeId != 0 || colorId != 0) ? " and po.ProductId = p.ProductId " : "") + (productId != 0 ? " and p.ProductId = ? " : "")
                    + (sizeId != 0 ? " and po.SizeId = ? " : "") + (colorId != 0 ? " and po.ColorId = ? " : "")
                    + (!filter.getName().isEmpty() ? " and p.ProductName like ? " : "")
                    + ((minPrice != 0 && maxPrice != 0 && minPrice < maxPrice) ? " and p.[Unit Price] between ? and ? \n" : "");
            int index = 1;
            PreparedStatement stm = connection.prepareStatement(sql);
            if (filter.getSubcategoryId() != 0) {
                stm.setInt(index, filter.getSubcategoryId());
                index++;
            }
            if (categoryId != 0) {
                stm.setInt(index, categoryId);
                index++;
            }
            if (productId != 0) {
                stm.setInt(index, productId);
                index++;
            }
            if (sizeId != 0) {
                stm.setInt(index, sizeId);
                index++;
            }
            if (colorId != 0) {
                stm.setInt(index, colorId);
                index++;
            }
            if (!filter.getName().isEmpty()) {
                stm.setNString(index, "%" + filter.getName() + "%");
                index++;
            }
            if (minPrice != 0 && maxPrice != 0 && minPrice < maxPrice) {
                stm.setInt(index, minPrice);
                stm.setInt(index + 1, maxPrice);
                index += 2;
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {

        }
        return 0;
    }

    public Object getListProducts(String unitPrice, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
