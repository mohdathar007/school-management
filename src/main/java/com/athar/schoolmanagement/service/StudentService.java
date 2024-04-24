package com.athar.schoolmanagement.service;


import com.athar.schoolmanagement.entity.Student;
import com.athar.schoolmanagement.mapper.StudentMapper;
import com.athar.schoolmanagement.repository.StudentRepository;
import com.athar.schoolmanagement.request.student.CreateStudentRequest;
import com.athar.schoolmanagement.request.student.UpdateStudentRequest;
import com.athar.schoolmanagement.response.student.CreateStudentResponse;
import com.athar.schoolmanagement.response.student.GetAllStudentResponse;
import com.athar.schoolmanagement.response.student.UpdateStudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    StudentRepository studentRepository;
    StudentMapper mapper;


    public List<GetAllStudentResponse> getAll() {
        List<Student> students = studentRepository.findAll();
        return mapper.toGetAllStudentResponse(students);
    }


    public Student getById(int id) {

        return studentRepository.findById(id).orElseThrow();
    }


    public CreateStudentResponse create(CreateStudentRequest request) {
        Student student = mapper.toStudent(request);


        studentRepository.save(student);

        return mapper.toCreateStudentResponse(student);
    }


    public UpdateStudentResponse update(UpdateStudentRequest request, int id) {
        Student student= studentRepository.findById(id).get();
        mapper.update(student, request);


        studentRepository.save(student);

        return mapper.toUpdateStudentResponse(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}