package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody Student student) {
        studentService.addStudents(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List> getStudentsByGender(@RequestParam(required = false) String gender) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByGender(gender));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentsById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudentInfo(@PathVariable int id, @RequestBody Student studentInfo) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, studentInfo));
    }

}
