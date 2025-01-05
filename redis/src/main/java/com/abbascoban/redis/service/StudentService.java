package com.abbascoban.redis.service;

import com.abbascoban.redis.model.Student;
import com.abbascoban.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CacheManager cacheManager;

   public List<Student> getAllStudents() {
       return studentRepository.findAll();
   }

   public Student getStudentById(Long id) {
       return studentRepository.getReferenceById(id);
   }

   public Student addStudent(Student student) {
       return studentRepository.save(student);
   }

   @Cacheable("cache-ismi")
   public String cacheFunc(String isim){
       try{
           Thread.sleep(3000);
           return isim;
       }
       catch (Exception e){
           return e.getMessage();
       }
   }

   public void cleanCache(){
       cacheManager.getCache("cache-ismi").clear();
   }
}
