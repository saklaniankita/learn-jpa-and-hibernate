package com.springboot.learnjpaandhibernate.course.springdatajpa;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
    List<Course> findByNameAndAuthor(String name, String author);
    List<Course> findByNameOrAuthor(String name, String author);

    @Query("Select c from Course c where c.name = ?1")
    List<Course> fetchCoursesByName(String name);

    @Query("Select c from Course c where c.name like %:suffix%")
    List<Course> fetchCoursesBySuffixName(@Param("suffix") String name);

}
