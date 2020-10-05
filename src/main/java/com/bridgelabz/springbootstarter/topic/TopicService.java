package com.bridgelabz.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic(1,"Java","Most widely user backend programming language"),
			new Topic(2,"Sql","Sql is the most idely used language to interact with database"),
			new Topic(3,"Frontend","Html,css and Javascript")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}

	public Topic getTopicById(int id) {
		return topics.stream().filter(topic -> topic.getId() == id).findAny().get();
	}

	public boolean addTopic(Topic topic) {
		return topics.add(topic);
	}

	public boolean updateTopic(int id, Topic topic) {
		for(int i = 0;i<topics.size(); i++ ) {
			if( topics.get(i).getId() == id) {
				topics.add(i, topic);
				return true;
			}
		}
		return false;
	}

	public boolean deleteTopic(int id) {
		for(int i = 0;i<topics.size(); i++ ) {
			if( topics.get(i).getId() == id) {
				topics.remove(i);
				return true;
			}
		}		
		return false;
	}

}
