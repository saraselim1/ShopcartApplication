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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.beans.Category;
import model.beans.Product;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Pc
 */
public class CategoryDAO {
    private Connection connection;
    private Statement stmt;
    String query;
    ResultSet rs;
    boolean connectionState=false;
    public CategoryDAO(){
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
    public int addCategory(Category c){
        boolean exist=false;
        int rows=0;           
              try{
                    query=new String("select * from product");
                    rs=stmt.executeQuery(query);
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        if(c.getId()==rs.getInt("ID"))
                        {
                           exist=true; 
                        }
                    }
                    if(!exist)
                    {
                        String new_query=new String("insert into CATEGORY( NAME , DESCRIPTION , PRODUCT_NUM) values ('" + c.getName() +"',"
                            +"'"+c.getDescription()+"',"
                            +c.getProductNum()+")");
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
    
    public int deleteCategory(int id){
        {
            int rows_effected=0;
              try{
                    query=new String("select * from CATEGORY");
                    rs=stmt.executeQuery(query); 
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        if(id==rs.getInt("ID"))
                        {
                           query=new String("delete from CATEGORY where ID ="+id);
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
    
     public int updateCategory(Category c)
        {
              int rows=0;
              try{
                    String new_query=new String("update CATEGORY set NAME='"+c.getName()+"',"+
                            "DESCRIPTION='"+c.getDescription()+"',"+
                            "PRODUCT_NUM="+c.getProductNum()+"where ID="+c.getId());
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
     
     public ArrayList<Category> getAllCategorys(){
        ArrayList<Category> categorys = null;
        ArrayList<Product> products =null;
        String productQuery;
        ResultSet productRs;
         try{
                categorys = new ArrayList<Category>();
                query=new String("select * from CATEGORY");
                rs=stmt.executeQuery(query);
                rs.beforeFirst();
                    while (rs.next())
                    {   
                        Category c = new Category();
                        c.setId(rs.getInt("ID"));
                        c.setDescription(rs.getString("DESCRIPTION"));
                        c.setName(rs.getString("NAME"));
                        c.setProductNum(rs.getInt("PRODUCT_NUM"));
                        productQuery = new String("select * from product where CATEGORY_ID="+c.getId());
                        productRs=stmt.executeQuery(productQuery);
                        productRs.beforeFirst();
                        while (productRs.next())
                        {   
                            Product p = new Product();
                            p.setId(rs.getInt("ID"));
                            p.setName(rs.getString("NAME"));
                            p.setQuantity(rs.getInt("QUANTITY_IN_STOCK"));
                            p.setPrice(rs.getInt("PRICE"));
                            p.setOffer(rs.getInt("OFFER"));
                            p.setDescription(rs.getString("DESCRIPTION"));
                            p.setCategoryId(rs.getInt("CATEGORY_ID"));
                            products.add(p);
                        }
                        c.setProducts(products);
                        categorys.add(c);
                    }
                   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return categorys;
    }
    
}
