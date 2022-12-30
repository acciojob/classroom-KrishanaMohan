package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    HashMap<String,Student> studentDB=new HashMap<>();
    HashMap<String,Teacher> teacherDB=new HashMap<>();
    HashMap<String, List<String>> pairDB=new HashMap<>();

    public void addStudent_R(Student student){

        studentDB.put(student.getName(),student);
    }
    public void addTeacher_R(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair_R(String teacher,String student){
        if(!pairDB.containsKey(teacher))
            pairDB.put(teacher,new ArrayList<>());
        pairDB.get(teacher).add(student);
    }
    public Student getStudentByName_R(String name){
        return studentDB.get(name);
    }
    public Teacher getTeacherByName_R(String name){
        return teacherDB.get(name);
    }
    public List<String> getStudentsByTeacherName_R (String teacher){
        return pairDB.get(teacher);
    }

    public List<String> getAllStudents_R(){
        List<String> allStudent=new ArrayList<>();
        for(String name:studentDB.keySet())
             allStudent.add(name);

        return allStudent;
    }
   public void deleteTeacherByName_R(String teacher){
       List<String> student=pairDB.get(teacher);
       pairDB.remove(teacher);
       for (String name:student){
           studentDB.remove(name);
       }
   }
   public void deleteAllTeachers_R(){
       List<String> student=new ArrayList<>();
       for(List<String> list:pairDB.values()){
           student.addAll(list);
       }
       pairDB.clear();

       for (String name:student){
           studentDB.remove(name);
       }
   }

}
