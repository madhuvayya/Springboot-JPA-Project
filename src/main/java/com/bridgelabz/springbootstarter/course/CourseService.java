package com.bridgelabz.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.springbootstarter.topic.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public boolean addCourse(Course course,int topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		if(courseRepository.save(course) != null) {
			return true;
		}
		return false;
	}

	public Course getCourse(int courseId) {
		return courseRepository.findById(courseId).get();
	}

}
