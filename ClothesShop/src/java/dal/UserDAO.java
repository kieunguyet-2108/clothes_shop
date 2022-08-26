/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends DBContext {

    public User getUser(String email, String password) {
        try {
            String sql = "select * from dbo.[Contact] where Email = ? and Password = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
                ,rs.getString(7),rs.getString(8),rs.getString(9));
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public User getUserByUidAndEmail(String userId, String email) {
        try {
            String sql = "select * from Contact\n"
                    + "where UserId = ? and Email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(userId));
            stm.setString(2, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
                ,rs.getString(7),rs.getString(8),rs.getString(9));
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public int checkEmailExit(String email) {
        try {
            String sql = "select count(*) from Contact\n"
                    + "where Email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public boolean insertUser(String email, String password) {
        try {
            String sql = "insert into dbo.[Contact] (Email,Password)\n"
                    + "values (?,?) ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}
