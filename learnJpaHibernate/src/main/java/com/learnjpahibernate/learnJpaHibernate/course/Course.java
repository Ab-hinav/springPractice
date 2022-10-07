package com.learnjpahibernate.learnJpaHibernate.course;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Course {

        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        private String author;

        public Course() {
        }
        public Course( String name, String author) {
            this.name = name;
            this.author = author;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        @Override
        public String toString() {
            return "Course [author=" + author + ", id=" + id + ", name=" + name + "]";
        }

}
