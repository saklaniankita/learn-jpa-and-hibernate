package com.springboot.learnspringdatajpa.course.jpa;

/**
 * Types of JPA Queries
 */

import com.springboot.learnspringdatajpa.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public List<Course> findByAuthor(String author) {
        Query query = entityManager.createQuery("select C from Course C where C.author =: author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    public List<Course> findByName(String name) {
        Query query = entityManager.createQuery("select C from Course C where C.name =: name");
        query.setParameter("name", name);
        return query.getResultList();
    }
}
