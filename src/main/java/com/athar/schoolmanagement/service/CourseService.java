package com.athar.schoolmanagement.service;



import com.athar.schoolmanagement.entity.Course;
import com.athar.schoolmanagement.mapper.CourseMapper;
import com.athar.schoolmanagement.repository.CourseRepository;
import com.athar.schoolmanagement.request.course.CreateCourseRequest;
import com.athar.schoolmanagement.request.course.UpdateCourseRequest;
import com.athar.schoolmanagement.response.course.CreateCourseResponse;
import com.athar.schoolmanagement.response.course.GetAllCourseResponse;
import com.athar.schoolmanagement.response.course.UpdateCourseResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    CourseRepository courseRepository;
    CourseMapper mapper;


    public List<GetAllCourseResponse> getAll() {
        List<Course> courses = courseRepository.findAll();
        return mapper.toGetAllCourseResponse(courses);
    }


    public Course getById(int id) {
        return courseRepository.findById(id).orElse(null);
    }


    public CreateCourseResponse
    create(CreateCourseRequest request) {
        Course course = mapper.toCourse(request);


        courseRepository.save(course);

        return mapper.toCreateCourseResponse(course);
    }


    public UpdateCourseResponse update(UpdateCourseRequest request, int id) {
        Course course= courseRepository.findById(id).get();
        mapper.update(course, request);


        courseRepository.save(course);

        return mapper.toUpdateCourseResponse(course);
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}