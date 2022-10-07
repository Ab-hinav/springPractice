package com.learnjpahibernate.learnJpaHibernate.course.jdbc;

import com.learnjpahibernate.learnJpaHibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springjdbcTemplate;

    private static String INSERT_COURSE =
            """
                    INSERT INTO COURSE (Name, author) VALUES (?, ?);
            """;

    private static String DELETE_COURSE =
            """
                    DELETE FROM COURSE WHERE ID = ?;
            """;

    private static String QUERY_COURSE =
            """
                    SELECT * FROM COURSE WHERE ID = ?;
            """;
    public void insert(Course course) {
        // insert into course (name, author) values ('abc', 'JDBC')
        springjdbcTemplate.update(INSERT_COURSE, course.getName(), course.getAuthor());
    }

    public void deleteById(Long id) {
        // delete from course where id = ?
        springjdbcTemplate.update(DELETE_COURSE, id);
    }

    public Course findById(Long id) {
        // select * from course where id = ?
        return springjdbcTemplate.queryForObject(QUERY_COURSE, new BeanPropertyRowMapper<>(Course.class),id);
    }

}
