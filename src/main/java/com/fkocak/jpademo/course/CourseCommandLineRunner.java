package com.fkocak.jpademo.course;

import com.fkocak.jpademo.course.jpa.CourseJpaRepository;
import com.fkocak.jpademo.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//This implementation is used to make it accept command line inputs
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //WITH SPRING JDBC -------------------------------------------------------------------

    //@Autowired
    //private CourseJdbcRepository repository;

    //-------------------------------------------------------------------------------------



    //WITH SPRING JDA ---------------------------------------------------------------------

//    @Autowired
//    private CourseJpaRepository repository;

    //-------------------------------------------------------------------------------------


    //WITH SPRING DATA JDA !!!!!! ---------------------------------------------------------

    @Autowired
    private CourseSpringDataJpaRepository repository;

    //-------------------------------------------------------------------------------------

    @Override //Had to be implemented as method and its executed at start up
    public void run(String... args) throws Exception {
        //JDBC and JDA -------------------
//        repository.insert(new Course(1,"Learn Spring","Furkan"));
//        repository.insert(new Course(2,"Learn Spring Boot","Furkan"));
//        repository.insert(new Course(3,"Learn Spring Rest","Furkan"));

        //SPRING DATA JDA (has its own methods for crud operations!!!!!)
        repository.save(new Course(1,"Learn Spring","Furkan"));
        repository.save(new Course(2,"Learn Spring Boot","Furkan"));
        repository.save(new Course(3,"Learn Spring Rest","Furkan"));

        repository.deleteById(3L);

        System.out.println(repository.findById(2L));

        //Custom method example
        System.out.println(repository.findByAuthor("Furkan"));
    }



}
