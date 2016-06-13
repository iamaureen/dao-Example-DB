/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoexampledb;

/**
 *
 * @author Ishrat
 */
public class DaoExampleDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StudentDao studentDao=new StudentDaoImpl();
        //display
        System.out.println("Initial student Info from database: ");
        studentDao.getAllStudents();        
        //insert
        Student st=new Student("tusty", 12);
        studentDao.insertStudent(st);        
        //display
        System.out.println("After Insertion: ");
        studentDao.getAllStudents();
        //delete
        studentDao.deleteStudent(12);
        System.out.println("After Deletion: ");        
        studentDao.getAllStudents();     
        
        //update
        Student stnew=new Student("maureen", 1);
        studentDao.updateStudentName(stnew);
        System.out.println("After Update: ");        
        studentDao.getAllStudents();
        
        
    }
    
}
