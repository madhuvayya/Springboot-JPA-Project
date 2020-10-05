package com.bridgelabz.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(value="/topics/{topicId}/courses",method = RequestMethod.POST)
	public String addcourse(@RequestBody Course course,@PathVariable int topicId) {
		
		if(courseService.addCourse(course,topicId)) {
			return "Course added";
		}
		return "Failed to add Course";
	}
}
