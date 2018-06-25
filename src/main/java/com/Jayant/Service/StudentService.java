package com.Jayant.Service;

import com.Jayant.DAO.FakeStudentDAOImpl;
import com.Jayant.DAO.StudentDAO;
import com.Jayant.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("fakeData")
    private StudentDAO studentDAO;

    public Collection<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.studentDAO.getStudentById(id);
    }

    public void deleteStudentById(int id) {
        this.studentDAO.deleteStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDAO.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDAO.insertStudentToDb(student);
    }
}
