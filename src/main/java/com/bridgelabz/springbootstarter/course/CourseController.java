package com.bridgelabz.springbootstarter.course;

import java.util.List;

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
	
	
	@RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable int courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(value = "topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
	public String updateCourse(@RequestBody Course course,@PathVariable int topicId) {
		if(courseService.updateCourse(course,topicId))
			return "Course Updated";
		return "Failed to update course";
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable int topicId){
		return courseService.getAllCouses(topicId);
	}
}
