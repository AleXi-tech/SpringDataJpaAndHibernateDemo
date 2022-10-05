package com.fkocak.jpademo.course.jpa;

import com.fkocak.jpademo.course.Course;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository //THIS DOES EXACTLY THE SAME AS CourseJdbcRepository IN SUCH A SIMPLE WAY
@Transactional
public class CourseJpaRepository { //DOESN'T EVEN REQUIRE LONG SQL QUERIES

    @PersistenceContext //Better usage than @Autowired for entity management
    private EntityManager entityManager; //Needed to control entity

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course course = findById(id);
        entityManager.remove(course);
    }
}
