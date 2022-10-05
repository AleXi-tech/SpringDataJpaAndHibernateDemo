package com.fkocak.jpademo.course.springdatajpa;

import com.fkocak.jpademo.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    //.. JpaRepository<Course, Long> <= Entity class name and id class

    //THAT'S ALL !!!
    //NO METHODS TO IMPLEMENT !!!
    //IT HAS ITS OWN CRUD METHODS !!!



    //You can write your own custom methods here if required for example
    //Search by author name (You dont even need a body to filter or anything. Sprind data jpa find it by
    // naming convention !!!)
    List<Course> findByAuthor(String author); // P.S. interface methods don't have a body!!!
}
