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
    public ProductDAO(){
       try
		{
			DriverManager.registerDriver(new OracleDriver());
			connection=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","bothinah","123");
                        stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                        query=new String("select * from product");
//                        rs=stmt.executeQuery(query);
//                        while(rs.next())
//                        {
//                                System.out.println("here");
//                        }
                       // stmt.close();
                       // con.close();
                       // System.out.println("done");d
                }catch(SQLException ex)
                {
                        ex.printStackTrace();
                }
    }
//    public static void main(String[] args){
//        ProductDAO p =new ProductDAO();
//    }
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
    
    public int deleteProduct(int id){
        {
            int rows_effected=0;
              try{
                    query=new String("select * from product");
                    rs=stmt.executeQuery(query); 
                    rs.beforeFirst();
                    while(rs.next())
                    {
                        if(id==rs.getInt("ID"))
                        {
                           query=new String("delete from product where ID ="+id);
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
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> products = null;
         try{
                products = new ArrayList<Product>();
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
                        products.add(p);
                    }
                   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return products;
    }
    
    public ArrayList<Product> getProductByCategory(int categoryId){
        ArrayList<Product> products = null;
         try{
                products = new ArrayList<Product>();
                query=new String("select * from product where CATEGORY_ID ="+categoryId);
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
                        products.add(p);
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
                String nameLower= name.toLowerCase();
                query=new String("select * from product where NAME ='"+nameLower+"'");
                rs=stmt.executeQuery(query);
                    if(rs.next())
                    {   
                        p.setId(rs.getInt("ID"));
                        p.setName(rs.getString("NAME"));
                        p.setQuantity(rs.getInt("QUANTITY_IN_STOCK"));
                        p.setPrice(rs.getInt("PRICE"));
                        p.setOffer(rs.getInt("OFFER"));
                        p.setDescription(rs.getString("DESCRIPTION"));
                        p.setCategoryId(rs.getInt("CATEGORY_ID"));
                    }
                   
                   
              }catch(SQLException ex)
              {
                        ex.printStackTrace();
              }
         return p;
    }
}
