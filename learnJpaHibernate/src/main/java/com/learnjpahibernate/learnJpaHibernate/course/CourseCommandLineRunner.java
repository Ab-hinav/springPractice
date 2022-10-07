package com.learnjpahibernate.learnJpaHibernate.course;

import com.learnjpahibernate.learnJpaHibernate.course.Course;
import com.learnjpahibernate.learnJpaHibernate.course.jdbc.CourseJdbcRepository;
import com.learnjpahibernate.learnJpaHibernate.course.jpa.CourseJpaRepository;
import com.learnjpahibernate.learnJpaHibernate.course.springDataJpa.CourseSpringDataJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpa repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course("JDBC", "JDBC"));
        repository.save(new Course("abc", "JDBC"));
        repository.save(new Course("cds", "JDBC"));
        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
    }
}

