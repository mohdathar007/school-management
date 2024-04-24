package com.athar.schoolmanagement.response.student;




import com.athar.schoolmanagement.response.course.CourseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentResponse {
    private int id;
    private String name;
    private List<CourseResponse> courses;
}