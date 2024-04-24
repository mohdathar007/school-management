package com.athar.schoolmanagement.mapper;


import com.athar.schoolmanagement.entity.Student;
import com.athar.schoolmanagement.request.student.CreateStudentRequest;
import com.athar.schoolmanagement.request.student.UpdateStudentRequest;
import com.athar.schoolmanagement.response.student.CreateStudentResponse;
import com.athar.schoolmanagement.response.student.GetAllStudentResponse;
import com.athar.schoolmanagement.response.student.UpdateStudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    GetAllStudentResponse toGetAllStudentResponse(Student student);
    List<GetAllStudentResponse> toGetAllStudentResponse(List<Student> students);
    Student toStudent(CreateStudentRequest request);
    CreateStudentResponse toCreateStudentResponse(Student student);
    void update(@MappingTarget Student student, UpdateStudentRequest request);
    UpdateStudentResponse toUpdateStudentResponse(Student student);
}