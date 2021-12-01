package com.restHeroku.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restHeroku.entity.Courses;
import com.restHeroku.service.CourseService;

@RestController
@RequestMapping("/api")
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
    public List<Courses> getCourse(){
        return this.courseService.getCources();
    }
	
	@GetMapping("/courses/{id}")
    public Object home(@PathVariable String id){
		System.out.println("Value from URI "+id);
        return this.courseService.getCources(Long.parseLong(id));
    }
	
	
	@PostMapping("/courses/add")
    public Object dataFromPostman(@RequestBody Courses course){
		return this.courseService.addCourse(course);
    }
	
	@DeleteMapping("/courses/{id}")
	public String deleteCourse(@PathVariable String id) {
		return this.courseService.delCourse(Integer.parseInt(id));
	}
}
