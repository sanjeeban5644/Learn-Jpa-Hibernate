package com.sanjeeban.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sanjeeban.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				insert into course(id,name,author)
				values(?,?,?);
			
			
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,
				course.getId(),course.getName(),course.getAuthor());
	}
	
	private static String DELETE_QUERY = 
			"""
			delete from course where id = ?;
			
			""";
	
	public void deletebyId(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	
	private static String SELECT_QUERY = 
			"""
			select * from course
			where id = ?;
			
			""";
	
	public Course selectbyId(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				 new BeanPropertyRowMapper<>(Course.class),id);
	}
	
	
}
