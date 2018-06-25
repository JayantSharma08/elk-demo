package com.Jayant.DAO;

import com.Jayant.Entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDAOImpl implements StudentDAO {

    private static Logger logger = LoggerFactory.getLogger(FakeStudentDAOImpl.class);



    private static Map<Integer, Student> students;
    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1,new Student(1, "Sam", "Mechanical"));
                put(2,new Student(2, "Bob", "Computer Science"));
                put(3,new Student(3, "Kim", "Civil"));
            }
        };
    }
    @Override
    public Collection<Student> getAllStudents(){
        logger.trace("Getting all students.....");
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        logger.debug("Getting a specific student...");
        return this.students.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        logger.warn("Deleting a student!!");
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        logger.info("Updating a student...");
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudentToDb(Student student) {
        logger.error("Inserting student......");
        students.put(student.getId(), student);
    }
}
