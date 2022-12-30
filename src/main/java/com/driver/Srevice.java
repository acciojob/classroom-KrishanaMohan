package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Srevice {
    @Autowired
    Repository repository;
    public void addStudent_S(Student student){
        repository.addStudent_R(student);
    }
    public void addTeacher_S(Teacher teacher){
        repository.addTeacher_R(teacher);
    }
    public void addStudentTeacherPair(String teacher,String student){
        repository.addStudentTeacherPair_R(teacher,student);
    }
    public Student getStudentByName_S(String name){
        return repository.getStudentByName_R(name);
    }
    public Teacher getTeacherByName_S(String name){
        return repository.getTeacherByName_R(name);
    }
    public List<String> getStudentsByTeacherName_S(String teacher){
        return repository.getStudentsByTeacherName_R(teacher);
    }
    public  List<String> getAllStudents_S(){
        return repository.getAllStudents_R();
    }
    public void deleteTeacherByName_S(String teacher){
         repository.deleteTeacherByName_R(teacher);
    }
    public void deleteAllTeachers_S(){
        repository.deleteAllTeachers_R();
    }
}
