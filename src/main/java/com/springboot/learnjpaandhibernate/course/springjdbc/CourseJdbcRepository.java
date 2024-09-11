package com.springboot.learnjpaandhibernate.course.springjdbc;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * illustrates SpringJDBC
 */
@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY = """
            insert into course(id, name, author) 
            values (?, ?, ?);
            """;

    private static String DELETE_QUERY = """
            delete from course where id = ?
            """;

    private static String SELECT_QUERY = """
            select * from course where id = ?
            """;

    private static String SELECT_BY_AUTHOR = """
            select * from course where author = ?
            """;

    private static String SELECT_BY_NAME = """
            select * from course where name = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public List<Course> findByAuthor(String author) {
        return springJdbcTemplate.query(SELECT_BY_AUTHOR, new BeanPropertyRowMapper<>(Course.class), author);
    }

    public List<Course> findByName(String name) {
        return springJdbcTemplate.query(SELECT_BY_NAME, new BeanPropertyRowMapper<>(Course.class), name);
    }
}
