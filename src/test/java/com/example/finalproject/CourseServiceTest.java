package com.example.finalproject;

import com.example.finalproject.Model.Course;
import com.example.finalproject.Repository.CourseRepository;
import com.example.finalproject.Service.CourseService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

//    @InjectMocks
//    private CourseService courseService;
//
//    @Mock
//    private CourseRepository courseRepository;
//
//    private List<Course> courses;

//    public Course(int i, String s, String bestCourseInTheSemester, String video, String calculas) {
//    }

//    @BeforeEach
//    void setUp() {
//
//        courses = new ArrayList<>();
//        courses.add(new Course(1,"Math 101","best course in the semester","video","calculas"));
//        courses.add(new Course(2,"Science 102","best course in the semester","zoom","biology"));
//    }
//
//        @Test
//        public void getAllCoursesTest () {
//
//            when(courseRepository.findAll()).thenReturn(courses);
//
//
//            List<Course> result = courseService.getAllCourses();
//
//
//            assertEquals(2, result.size());
//            assertEquals(courses, result);
//            verify(courseRepository, times(1)).findAll();
//        }
//
//    }
}
