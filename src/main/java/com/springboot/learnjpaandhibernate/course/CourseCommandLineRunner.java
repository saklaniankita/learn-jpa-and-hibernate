package com.springboot.learnjpaandhibernate.course;

import com.springboot.learnjpaandhibernate.course.springjdbc.CourseJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

//    @Autowired
//    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Spring now!", "ankita"));
        repository.insert(new Course(2, "Learn Spring Boot now!", "saklani"));
        repository.insert(new Course(3, "Learn Java now!", "ankita"));
        repository.insert(new Course(4, "Learn Python now!", "saklani"));
//        repository.save(new Course(1, "Learn Java now!", "ankita"));
//        repository.save(new Course(2, "Learn Python now!", "saklani"));
//        repository.save(new Course(3, "Learn Spring now!", "ankita"));
//        repository.save(new Course(4, "Learn Spring Boot now!", "saklani"));
//        repository.save(new Course(5, "Learn Docker now!", "ankita"));
//        repository.save(new Course(6, "Learn Junit now!", "saklani"));


        logger.info(repository.findById(1L).toString());
        logger.info(repository.findById(2L).toString());
        repository.deleteById(2L);

        logger.info(repository.findByAuthor("ankita").toString());
        logger.info(repository.findByName("Learn Spring now!").toString());
    }
}
