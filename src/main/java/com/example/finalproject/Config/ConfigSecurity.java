package com.example.finalproject.Config;

import org.springframework.context.annotation.Bean;
import com.example.finalproject.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity {

    private final MyUserDetailsService myUserDetailsService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeHttpRequests()

                //Auth
                //get All users
                .requestMatchers("/api/v1/auth/get").hasAuthority("ADMIN")
                //delete user
                .requestMatchers("/api/v1/auth/delete/{user_id}").hasAuthority("ADMIN")

                //Tutor
                .requestMatchers("/api/v1/tutor/get").permitAll()
                //Tutor register
                .requestMatchers("/api/v1/tutor/register").permitAll()
                .requestMatchers("/api/v1/tutor/update").hasAuthority("TUTOR")
                .requestMatchers("/api/v1/tutor/delete").hasAuthority("TUTOR")
                //getAllTutorsWithRecommendations
                .requestMatchers("/api/v1/tutor/tutorsWithRecommendations").permitAll()

                //Student
                .requestMatchers("/api/v1/student/get").hasAuthority("ADMIN") //+tutor??
                .requestMatchers("/api/v1/student/register").permitAll()
                .requestMatchers("/api/v1/student/update").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/student/delete").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/student/studentEnrollment/{course_id}").hasAnyAuthority("STUDENT", "ADMIN")

                //Course
                .requestMatchers("/api/v1/course/get").permitAll()
                .requestMatchers("/api/v1/course/add").hasAnyAuthority("TUTOR", "ADMIN")
                .requestMatchers("/api/v1/course/update/{course_id}").hasAnyAuthority("TUTOR", "ADMIN")
                .requestMatchers("/api/v1/course/delete/{course_id}").hasAnyAuthority("TUTOR", "ADMIN")
                .requestMatchers("/api/v1/course/courseFilter/{minPrice}/{maxPrice}").permitAll()
                .requestMatchers("api/v1/course/findCoursesByLearningMethod/{learningMethod}").permitAll()
                .requestMatchers("api/v1/course/mostPopularCourses").permitAll()


               /////////////////////////////// //Renad/////////////////////////////////////////////////

                //Auth
                .requestMatchers("/api/v1/auth/get/users/role/{role}").hasAuthority("ADMIN")

                //Review
                .requestMatchers("/api/v1/review/get").permitAll()
                .requestMatchers("api/v1/review/update/{review_id}").hasAnyAuthority("TUTOR", "ADMIN")
                .requestMatchers("/api/v1/review/delete/{review_id}").hasAuthority("ADMIN")

                //Club
                .requestMatchers("/api/v1/club/get").permitAll()
                .requestMatchers("/api/v1/club/add/{studentId}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/club/update/{club_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/club/delete/{club_id}").hasAuthority("ADMIN")

                .requestMatchers("/api/v1/club/get/club/{name}").permitAll()
                .requestMatchers("/api/v1/club/get/details/{club_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/club/students/{club_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/club/capacity/{capacity}").hasAuthority("STUDENT")


                //UsedItem
                .requestMatchers("/api/v1/usedItem/get").permitAll()
                .requestMatchers("/api/v1/usedItem/add/{sellerId}").hasAnyAuthority("TUTOR", "STUDENT")
                .requestMatchers("/api/v1/usedItem/update/{usedItem_id}").hasAnyAuthority("TUTOR", "STUDENT")
                .requestMatchers("/api/v1/usedItem/delete/{usedItem_id}").hasAuthority("ADMIN")


                //Orders
                .requestMatchers("/api/v1/orders/get").permitAll()
                .requestMatchers("/api/v1/orders/add").hasAnyAuthority("TUTOR", "STUDENT")
                .requestMatchers("/api/v1/orders/update/{orders_id}").hasAnyAuthority("TUTOR","STUDENT")
                .requestMatchers("/api/v1/orders/delete/{orders_id}").hasAnyAuthority("TUTOR","STUDENT")
                .requestMatchers("/api/v1/orders/get/order/{status}").permitAll()
                .requestMatchers("/api/v1/orders/changeStatus/{order_id}/{status}").hasAuthority("ADMIN")


                //Exam
                .requestMatchers("/api/v1/exam/get").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/exam/get/my").hasAuthority("TUTOR")
                .requestMatchers("/api/v1/exam/add").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/exam/update/{exam_id}").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/exam/delete/{exam_id}").hasAuthority("ADMIN")



                //myCourse endpoint
                .requestMatchers("/api/v1/course/get/course/{course_id}").hasAuthority("TUTOR")
                .requestMatchers("/api/v1/course/get/tutor/{tutor_id}").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/course/get/subject/{subject}").permitAll()
                .requestMatchers("/api/v1/course/get/details/{course_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/course/get/course/reviews/{course_id}").permitAll()

                //myTutor endpoint
                .requestMatchers("/api/v1/tutor/get/name/{firstName}").permitAll()
                .requestMatchers("/api/v1/tutor/get/tutor/reviews/{tutor_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/tutor/get/avg/{tutor_id}").hasAuthority("STUDENT")
                .requestMatchers("/api/v1/tutor/get/tutor/products/{tutor_id}").permitAll()
                .requestMatchers("/api/v1/tutor/get/tutors/{gpa}").hasAuthority("STUDENT")

                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();

    }
}

