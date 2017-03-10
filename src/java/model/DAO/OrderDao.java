/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

/**
 *
 * @author Masoud
 */
public class OrderDao extends DBConnector {

    public OrderDao() {
        select = "select * from order where user_name = ?";
        insert = "insert into users (user_name, fname, lname, email, gender) values (?, ?, ?, ?, ?)";
        update = "update users set user_name = ?, fname = ?, lname = ?, email = ?, gender = ? where user_name = ?";
        delete = "delete from users where user_name = ?";
    }
}
