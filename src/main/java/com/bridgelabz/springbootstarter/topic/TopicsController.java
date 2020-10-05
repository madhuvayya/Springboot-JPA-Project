package com.bridgelabz.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") int id) {
		Topic topic = topicService.getTopicById(id);
		if(!topic.equals(null)) {
			return topic;
		}
		return null;
	}
	
	@RequestMapping(value="/topics",method = RequestMethod.POST)
	public String addTopic(@RequestBody Topic topic) {
		if(topicService.addTopic(topic)) {
			return "Topic added";
		}
		return "Failed to add topic";
	}
	
	@RequestMapping(value="/topics/{id}",method = RequestMethod.PUT)
	public String updateTopic(@PathVariable int id,@RequestBody Topic topic) {
		if(topicService.updateTopic(id,topic)) {
			return "Topic updated";
		}
		return "Failed to update topic";
	}

	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable int id) {
		if(topicService.deleteTopic(id)) {
			return "Topic Deleted";
		}
		return "Topic not deleted";
	}
}
