/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Masoud
 */
public abstract class DBConnector {

    private final String dbUserName;
    private final String dbPassword;
    private final String ipAddress;
    private final String port;

    private boolean connectionState;
    
    private Driver driver;
    private Connection connection;
    
    protected Statement statement;
    protected PreparedStatement pStatement;
    protected ResultSet resultSet;
    protected String select;
    protected String insert;
    protected String update;
    protected String delete;

    protected DBConnector() {
        dbUserName = "servlet";
        dbPassword = "servlet";
        ipAddress = "127.0.0.1";
        port = "1521";

        connectionState = false;

        driver = new oracle.jdbc.driver.OracleDriver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean connect() {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@" + ipAddress + ":" + port + ":xe", dbUserName, dbPassword);
            connectionState = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connectionState;
    }

    public void disconnect() {
        try {
            if (connectionState) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected ResultSet getAll(String table) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "Select * from " + table + " order by id";
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    protected void runQuery(String query){
        try {
            pStatement = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}