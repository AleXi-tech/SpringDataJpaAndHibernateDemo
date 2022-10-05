package com.fkocak.jpademo.course.jdbc;

import com.fkocak.jpademo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//This annotation is used to communicate with database
@Repository
public class CourseJdbcRepository {

    @Autowired //there might be an ide related error about not being able to find bean, run it anyway
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            "INSERT INTO course (id,name,author)\n" +
            "VALUES(?,?,?)"; // By question marks we are able to pass the values as arguments
                             //after creating the appropriate class

    private static String DELETE_QUERY =
            "DELETE FROM course WHERE id=?";

    private static String SELECT_QUERY =
            "SELECT * FROM course";

    private static String SELECT_QUERY_BY_ID =
            "SELECT * FROM course WHERE id=?";


    public void insert(Course course){
        springJdbcTemplate.update(
                INSERT_QUERY,
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void delete(long id){
        springJdbcTemplate.update(
                DELETE_QUERY,
                id
        );
    }

    public void selectAll(){
        springJdbcTemplate.update(
                SELECT_QUERY
        );
    }

    //HOW TO RETRIEVE SINGLE ITEM
    public Course selectById(long id){
        return springJdbcTemplate.queryForObject( //queryForObject is used if we are expecting a specific object
                SELECT_QUERY_BY_ID,
                new BeanPropertyRowMapper<>(Course.class), //We want a ResultSet to a Bean and Bean to Row Mapper ****
                id
        );

    }
}
