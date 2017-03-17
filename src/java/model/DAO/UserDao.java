/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.User;

/**
 *
 * @author Masoud
 */
public class UserDao extends DBConnector {

    User user;
    List<User> users;

    public UserDao() {
        select = "select * from users where user_name = ? and password = ? ";
        insert = "insert into users (user_name, fname, lname, email, gender, password, address) values (?, ?, ?, ?, ?, ?, ?)";
        update = "update users set user_name = ?, fname = ?, lname = ?, email = ?, gender = ?, password = ?, address = ? where user_name = ?";
        delete = "delete from users where user_name = ?";
    }

    public List<User> getAllUsers() {
        try {
            resultSet = getAll("users");
            users = new ArrayList<>();
            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User getUser(String userName, String password) {
        runQuery(select);
        user = null;
        try {
            pStatement.setString(1, userName);
            pStatement.setString(2, password);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean addUser(User user) {
        try {
            runQuery(insert);
            pStatement.setString(1, user.getUserName());
            pStatement.setString(2, user.getFname());
            pStatement.setString(3, user.getLname());
            pStatement.setString(4, user.getEmail());
            pStatement.setString(5, user.getGender());
            pStatement.setString(6, user.getPassword());
            pStatement.setString(7, user.getAddress());
            int rowCount = pStatement.executeUpdate();
            if (rowCount > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateUser(String userName, User user) {
        try {
            runQuery(update);
            pStatement.setString(1, user.getUserName());
            pStatement.setString(2, user.getFname());
            pStatement.setString(3, user.getLname());
            pStatement.setString(4, user.getEmail());
            pStatement.setString(5, user.getGender());
            pStatement.setString(6, user.getPassword());
            pStatement.setString(7, user.getAddress());
            pStatement.setString(8, user.getUserName());
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(String userName) {
        try {
            runQuery(delete);
            pStatement.setString(1, userName);
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
