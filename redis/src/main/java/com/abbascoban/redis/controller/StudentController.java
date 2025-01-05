package com.abbascoban.redis.controller;

import com.abbascoban.redis.model.Student;
import com.abbascoban.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
   public Student getStudentById(@RequestParam Long id) {
       return studentService.getStudentById(id);
   }

   @GetMapping("/list")
   public List<Student> getAllStudents() {
        return studentService.getAllStudents();
   }

   @PostMapping("/save")
   public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
   }

   @GetMapping("/cache")
   public String cacheFunc(@RequestParam String isim){
        return studentService.cacheFunc(isim);
   }

   @GetMapping("/cacheclear")
    public void cacheClear(){
        studentService.cleanCache();
   }
   @GetMapping("/responce")
    public ResponseEntity<String> responce(@RequestParam String ad){
      return ResponseEntity.ok(ad);
   }
}
