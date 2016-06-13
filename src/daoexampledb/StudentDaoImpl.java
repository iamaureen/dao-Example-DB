/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoexampledb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ishrat
 */
public class StudentDaoImpl implements StudentDao {

      
    // constructor
    public StudentDaoImpl(){
        
    }

    @Override
    public void getAllStudents()  {
        Connectionfactory cf = new Connectionfactory();
        Connection con=cf.getConnection();
        
        PreparedStatement ps = null;
	ResultSet rs = null;
        
        try{
            String query = "Select * from student";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("student_id");
                String name=rs.getString("first_name");
                
                System.out.println("ID: " + id + ", Name: " + name);
            }
        
            rs.close();
            ps.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
        
    }

    

    @Override
    public void updateStudentName(Student st) {
        Connectionfactory cf = new Connectionfactory();
        Connection con=cf.getConnection();
        
        PreparedStatement ps = null;
	ResultSet rs = null;
        
        try{
            String query = "UPDATE student SET first_name=? where student_id=?";
            ps = con.prepareStatement(query);
           
            ps.setString(1, st.getName());
            ps.setInt(2, st.getRollNo());
            
            ps.executeUpdate();
            //close the connection
            ps.close();
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int st) {
        Connectionfactory cf = new Connectionfactory();
        Connection con=cf.getConnection();
        
        PreparedStatement ps = null;
	ResultSet rs = null;
        
        try{
            String query = "delete from student where student_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, st);            
                        
            ps.executeUpdate();
            //close the connection
            ps.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertStudent(Student st) {
        Connectionfactory cf = new Connectionfactory();
        Connection con=cf.getConnection();
        
        PreparedStatement ps = null;
	ResultSet rs = null;
        
        try{
            String query = "Insert into student values (?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, st.getRollNo());
            ps.setString(2, st.getName());
                        
            ps.execute();
            //close the connection
            ps.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
    
}
