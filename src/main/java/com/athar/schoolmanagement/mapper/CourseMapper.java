package com.athar.schoolmanagement.mapper;


import com.athar.schoolmanagement.entity.Course;
import com.athar.schoolmanagement.request.course.CreateCourseRequest;
import com.athar.schoolmanagement.request.course.UpdateCourseRequest;
import com.athar.schoolmanagement.response.course.CreateCourseResponse;
import com.athar.schoolmanagement.response.course.GetAllCourseResponse;
import com.athar.schoolmanagement.response.course.UpdateCourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "student.name", target = "studentName")
    GetAllCourseResponse toGetAllCourseResponse(Course course);
    List<GetAllCourseResponse> toGetAllCourseResponse(List<Course> courses);
    @Mapping(source = "studentId", target = "student.id")
    Course toCourse(CreateCourseRequest request);
    @Mapping(source = "student.id", target = "studentId")
    CreateCourseResponse toCreateCourseResponse(Course course);

    void update(@MappingTarget Course course, UpdateCourseRequest request);
    @Mapping(source = "student.id", target = "studentId")
    UpdateCourseResponse toUpdateCourseResponse(Course course);
}