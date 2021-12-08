package com.example.springsecurityintegration.model;

import com.example.springsecurityintegration.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "James bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return students.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " not found"));
    }

    @GetMapping("/get-jwt-token")
    public String getJWT() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Jwts.builder().setSubject("Joe").signWith(key).compact();
    }

}
