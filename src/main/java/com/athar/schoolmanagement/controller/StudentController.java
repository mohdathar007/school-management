package com.athar.schoolmanagement.controller;



import com.athar.schoolmanagement.entity.Student;
import com.athar.schoolmanagement.request.student.CreateStudentRequest;
import com.athar.schoolmanagement.request.student.UpdateStudentRequest;
import com.athar.schoolmanagement.response.student.CreateStudentResponse;
import com.athar.schoolmanagement.response.student.GetAllStudentResponse;
import com.athar.schoolmanagement.response.student.UpdateStudentResponse;
import com.athar.schoolmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllStudentResponse> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateStudentResponse create(@RequestBody CreateStudentRequest student) {
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UpdateStudentResponse update(@RequestBody UpdateStudentRequest student, @PathVariable int id) {
        return studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
}