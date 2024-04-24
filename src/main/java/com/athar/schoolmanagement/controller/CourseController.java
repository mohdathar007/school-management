package com.athar.schoolmanagement.controller;


import com.athar.schoolmanagement.entity.Course;
import com.athar.schoolmanagement.request.course.CreateCourseRequest;
import com.athar.schoolmanagement.request.course.UpdateCourseRequest;
import com.athar.schoolmanagement.response.course.CreateCourseResponse;
import com.athar.schoolmanagement.response.course.GetAllCourseResponse;
import com.athar.schoolmanagement.response.course.UpdateCourseResponse;
import com.athar.schoolmanagement.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCourseResponse> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Course getById(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCourseResponse create(@RequestBody CreateCourseRequest course) {
        return courseService.create(course);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UpdateCourseResponse update(@RequestBody UpdateCourseRequest course, @PathVariable int id) {
        return courseService.update(course, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

}