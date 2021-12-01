package com.restHeroku.service;

import java.util.List;

import com.restHeroku.entity.Courses;

public interface CourseService {
	public List<Courses> getCources();
	public Object getCources(long id);
	public Object addCourse(Courses course);
	public String delCourse(int id);
}
