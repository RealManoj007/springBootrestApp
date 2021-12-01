package com.restHeroku.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restHeroku.entity.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Courses> list;
	
	@Autowired
	Courses courses;
	
	public CourseServiceImpl(){
		
		list=new ArrayList<>();
		list.add(new Courses(1,"Java","All complete Cousres"));
		list.add(new Courses(2,"PHP","All complete Cousres with fix price"));
		list.add(new Courses(3,"C++","All complete Cousres with bast price"));
	}
	
	public List<Courses> getCources() {
		System.out.println("Here");
		return list;
	}
	
	public Object getCources(long id) {
		System.out.println("Id is "+id);
		Courses c=null;
		
		for(Courses courses:list) {
			if(courses.getId()==id) {
				c=courses;
				break;
			}
		}
		if(c!=null) {
			return c;
		}else {
			return "No result found";
		}
		
	}

	@Override
	public Object addCourse(Courses course) {
		for(Courses c:list) {
			if(c.getId()==course.getId()) {
				return "Please changes ID, user is already registered with this ID";
			}
		}
		
		list.add(course);
		return course;
	}

	@Override
	public String delCourse(int id) {
		list.remove(id-1);
		return "removed";
		
//		try {
//			for(Courses c:list) {
//				if(c.getId()==id) {
//					System.out.println(c.getId()+" : "+id);
//					list.remove(c.getId());
//					System.out.println(list);
//				}
//			}
//			return "testing";
//		} catch (Exception e) {
//			return "No user found";
//		}
	}
	
}
