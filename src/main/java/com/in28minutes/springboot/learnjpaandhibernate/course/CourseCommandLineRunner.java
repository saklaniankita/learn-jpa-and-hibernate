package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

//    @Autowired
//    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS now!", "in28minutes"));
        repository.insert(new Course(2, "Learn DOCKER now!", "Ranga"));
        repository.insert(new Course(3, "Learn Azure now!", "in28minutes"));
        repository.insert(new Course(4, "Learn Azure now!", "Ranga"));
//        repository.save(new Course(1, "Learn AWS now!", "in28minutes"));
//        repository.save(new Course(2, "Learn DOCKER now!", "Ranga"));
//        repository.save(new Course(3, "Learn Azure now!", "in28minutes"));
//        repository.save(new Course(4, "Learn Azure now!", "Ranga"));
//        repository.save(new Course(5, "Learn Azure now!", "in28minutes"));
//        repository.save(new Course(6, "Learn Azure now!", "Ranga"));

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));
        repository.deleteById(2L);

        System.out.println(repository.findByAuthor("Ranga"));
        System.out.println(repository.findByName("Learn Azure now!"));
    }
}
