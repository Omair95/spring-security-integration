package com.example.springsecurityintegration.model;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management")
public class StudentManagementController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "James bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping("/all-students")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("/new-student")
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(Student student) {
        System.out.println(student);
    }

    @DeleteMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping("{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student));
    }
}
