package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "鲁班", "female", "鲁班一号"));
        students.add(new Student(2, "大乔", "male", "大乔姐姐"));
        students.add(new Student(3, "小乔", "male", "小乔姐姐"));
        students.add(new Student(4, "后羿", "male", "后羿射日"));
        students.add(new Student(5, "猪八戒", "male", "大耙子"));
        students.add(new Student(6, "孙悟空", "male", "金箍棒"));
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public void deleteStudent(Integer id) {
        students.remove(id - 1);
    }

    public List<Student> getStudentsByGender(String gender) {
        if (gender == null) {
            return students;
        }
        return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudentById(int id) {
        return students.get(id - 1);
    }

    public Student updateStudent(int id, Student studentInfo) {
        Student student = students.get(id - 1);
        student.setGender(studentInfo.getGender() == null ? student.getGender():studentInfo.getGender());
        student.setName(studentInfo.getName() == null ? student.getName() : studentInfo.getName());
        student.setNote(studentInfo.getNote() == null ? student.getNote() : studentInfo.getNote());
        return student;
    }
}
