package com.learnjpahibernate.learnJpaHibernate.course.jdbc;

import com.learnjpahibernate.learnJpaHibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course("JDBC", "JDBC"));
        courseJdbcRepository.insert(new Course("abc", "JDBC"));
        courseJdbcRepository.insert(new Course("cds", "JDBC"));
        courseJdbcRepository.deleteById(1L);
        System.out.println(courseJdbcRepository.findById(2L));
    }
}

