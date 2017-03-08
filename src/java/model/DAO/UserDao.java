/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.User;

/**
 *
 * @author Masoud
 */
public class UserDao extends DBConnector {

    public UserDao() {
        select = "select * from users where user_name = ?";
        insert = "insert into users (user_name, fname, lname, email, gender) values (?, ?, ?, ?, ?)";
        update = "update users set user_name = ?, fname = ?, lname = ?, email = ?, gender = ? where user_name = ?";
        delete = "delete from users where user_name = ?";
    }

    User user;
    Vector<User> users;

    public List<User> getAllUsers() {
        try {
            resultSet = getAll("users");
            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User getUser(String userName) {
        runQuery(select);
        try {
            pStatement.setString(1, userName);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void addUser(User user) {
        try {
            runQuery(insert);
            pStatement.setString(1, user.getUserName());
            pStatement.setString(2, user.getFname());
            pStatement.setString(3, user.getLname());
            pStatement.setString(4, user.getEmail());
            pStatement.setString(5, user.getGender());
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateUser(String userName, User user) {
        try {
            runQuery(update);
            pStatement.setString(1, user.getUserName());
            pStatement.setString(2, user.getFname());
            pStatement.setString(3, user.getLname());
            pStatement.setString(4, user.getEmail());
            pStatement.setString(5, user.getGender());
            pStatement.setString(6, userName);
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
