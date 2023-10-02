package com.sanjeeban.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sanjeeban.springboot.learnjpaandhibernate.course.Course;
import com.sanjeeban.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.sanjeeban.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseComandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	//private CourseJpaRepository repository;
//	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"spring","sanjeeban"));
		repository.save(new Course(2,"devOps","kunal"));
		repository.save(new Course(3,"mobile","sanjeeban"));
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		
		
	}
	

}
