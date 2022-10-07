package com.learnjpahibernate.learnJpaHibernate.course.springDataJpa;

import com.learnjpahibernate.learnJpaHibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpa extends JpaRepository<Course,Long> {

}
