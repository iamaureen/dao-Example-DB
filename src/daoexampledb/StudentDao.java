/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoexampledb;

import java.util.List;

/**
 *
 * @author Ishrat
 */
public interface StudentDao {
    
    public void getAllStudents();
    public void insertStudent(Student st);    
    public void deleteStudent(int st);
    public void updateStudentName(Student student);
    
        
    
}
