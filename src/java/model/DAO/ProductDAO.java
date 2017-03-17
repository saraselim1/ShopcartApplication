/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Product;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Sara Selim
 */
public class ProductDAO {

    private Connection connection;
    private Statement stmt;
    String query;
    ResultSet rs;
    boolean connectionState=false;
    public ProductDAO(){
    
//			DriverManager.registerDriver(new OracleDriver());
//			connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","dbuser","dbuser");
//                        stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
    }

    public boolean connect() {
        try {
                    DriverManager.registerDriver(new OracleDriver());
                    connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","dbuser","dbuser");
                    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    connectionState=true;
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
    public int addProduct(Product p){
        boolean exist=false;
        int rows=0;           
              try{
                    query=new String("select * from product");
                    rs=stmt.executeQuery(query);
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        if(p.getId()==rs.getInt("ID"))
                        {
                           exist=true; 
                        }
                    }
                    if(!exist)
                    {
                        String new_query=new String("insert into product (NAME, QUANTITY_IN_STOCK, PRICE, OFFER, DESCRIPTION, CATEGORY_ID) values ('"
                            +p.getName()+"',"
                            +p.getQuantity()+","
                            +p.getPrice()+","
                            +p.getOffer()+","
                            +"'"+p.getDescription()+"'"
                            +p.getCategoryId()+")");
                    rows=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(new_query);
                    }
                    
              }catch(SQLIntegrityConstraintViolationException ex)
              {
                  ex.printStackTrace();
              }
              catch(java.sql.SQLSyntaxErrorException ex){
                  ex.printStackTrace();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
           
              return rows;
    }
    
    public int deleteProduct(String name){
        {
            int rows_effected=0;
              try{
                    query=new String("select * from product");
                    rs=stmt.executeQuery(query); 
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        if(name==rs.getString("NAME"))
                        {
                           query=new String("delete from product where NAME ='"+name+"'");
                           rows_effected=connection.createStatement().executeUpdate(query); 
                        }
                    }    
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
                        System.out.println("row does not exist");
              }
               return rows_effected;
        }
    }
    
    public int updateProduct(Product p)
        {
              int rows=0;
              try{
                    String new_query=new String("update product set NAME='"+p.getName()+"',"+
                            "QUANTITY_IN_STOCK="+p.getQuantity()+","+
                            "PRICE="+p.getPrice()+","+
                            "OFFER="+p.getOffer()+","+
                            "DESCRIPTION='"+p.getDescription()+"',"+
                            "CATEGORY_ID="+p.getCategoryId()+" where ID="+p.getId());
                    rows=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate(new_query);
                     
              }catch(SQLIntegrityConstraintViolationException ex)
              {
                  ex.printStackTrace();
              }
              catch(SQLException ex)
              {
                  ex.printStackTrace();
              }
              return rows;
        }
    public Vector<Product> getAllProducts(){
        Vector<Product> products = null;
         try{
                products = new Vector<Product>();
                query=new String("select * from product");
                rs=stmt.executeQuery(query);
                    while (rs.next())
                    {   
                        Product p = new Product();
                        p.setId(rs.getInt("ID"));
                        p.setName(rs.getString("NAME"));
                        p.setQuantity(rs.getInt("QUANTITY_IN_STOCK"));
                        p.setPrice(rs.getInt("PRICE"));
                        p.setOffer(rs.getInt("OFFER"));
                        p.setDescription(rs.getString("DESCRIPTION"));
                        p.setCategoryId(rs.getInt("CATEGORY_ID"));
                        p.setImgMaster(rs.getString("IMG"));
                        products.add(p);
                    }
                   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return products;
    }
    
    public Vector<Product> getProductByCategory(String name){
        Vector<Product> products = null;
         try{
                products = new Vector<Product>();
                query=new String("select * from CATEGORY where NAME ='"+name+"'");
                //rs.absolute(1);
                //System.out.println(name);
                ResultSet rs1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
                System.out.println("out");
                if(rs1 != null){
                    System.out.println("inside");
                rs1.beforeFirst();
                rs1.next();
                int categoryId = rs1.getInt("ID");
                System.out.println(categoryId);
                System.out.println(name);
                query=new String("select * from product where CATEGORY_ID ="+categoryId);
                ResultSet resultSet=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(query);
                    while (resultSet.next())
                    {   
                        Product p = new Product();
                        p.setId(resultSet.getInt("ID"));
                        p.setName(resultSet.getString("NAME"));
                        p.setQuantity(resultSet.getInt("QUANTITY_IN_STOCK"));
                        p.setPrice(resultSet.getInt("PRICE"));
                        p.setOffer(resultSet.getInt("OFFER"));
                        p.setDescription(resultSet.getString("DESCRIPTION"));
                        p.setCategoryId(resultSet.getInt("CATEGORY_ID"));
                        p.setImgMaster(resultSet.getString("IMG"));
                        products.add(p);
                    }
                }   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return products;
    }
    
    
     public Product getProductByName(String name){
         Product p = new Product();
         try{
               // String nameLower= name.toLowerCase();
                query=new String("select * from product where name = '"+name+"'");
                rs=stmt.executeQuery(query);
                    if(rs.next())
                    {  
                        String innerQuery = new String("select * from PRODUCT_IMAGES where PRODUCT_NAME = '"+name+"'");
                        ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(innerQuery);
                        resultSet.next();
                        p.setId(rs.getInt("ID"));
                        p.setName(rs.getString("NAME"));
                        p.setQuantity(rs.getInt("QUANTITY_IN_STOCK"));
                        p.setPrice(rs.getInt("PRICE"));
                        p.setOffer(rs.getInt("OFFER"));
                        p.setDescription(rs.getString("DESCRIPTION"));
                        p.setCategoryId(rs.getInt("CATEGORY_ID"));
                        p.setImgMaster(rs.getString("IMG"));
                        if(resultSet != null){
                            p.setImg1(resultSet.getString("IMG1"));
                            p.setImg2(resultSet.getString("IMG2"));
                            p.setImg3(resultSet.getString("IMG3"));
                        }
                    }
                   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return p;
    }
   
     
     
}
