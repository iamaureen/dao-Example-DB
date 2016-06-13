/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoexampledb;

import java.sql.*;   //first step
/**
 *
 * @author Ishrat
 */
public class Connectionfactory {
    private Connection myCon;
    
    //static reference to itself
    private static Connectionfactory instance = new Connectionfactory();
    
   //strings needed for establishing connection
    public static final String driverClass="com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost/daoexample";
    public static final String user = "root";
    public static final String password = "";
    // url=jdbc:mysql://localhost/*database name from mysql*
    
   
    public Connection createConnection()  {
        try{
            Class.forName(driverClass);   //second step
            myCon=DriverManager.getConnection(url, user, password); //third step
       }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
        
        return myCon;
    }
    
    public Connection getConnection(){
        return instance.createConnection();
    }
}
