package com.bridgelabz.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
			new Topic(1,"Java","Most widely user backend programming language"),
			new Topic(2,"Sql","Sql is the most idely used language to interact with database"),
			new Topic(3,"Frontend","Html,css and Javascript")
			));
	
	public List<Topic> getAllTopics(){
		//return topicsList;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
						.forEach(topics::add);
		return topics;
	}

	public Topic getTopicById(int id) {
		//return topicsList.stream().filter(topic -> topic.getId() == id).findAny().get();
		return topicRepository.findById(id).get();
	}

	public boolean addTopic(Topic topic) {
		// return topicsList.add(topic);
		if(topicRepository.save(topic) != null) {
			return true;
		}
		return false;
	}

	public boolean updateTopic(int id, Topic topic) {
//		for(int i = 0;i<topicsList.size(); i++ ) {
//			if( topicsList.get(i).getId() == id) {
//				topicsList.add(i, topic);
//				return true;
//			}
//		}

		// save method also update data based on id, no need to provide id   
		if(topicRepository.save(topic) != null) {
			return true;
		}
		
		return false;
	}

	public boolean deleteTopic(int id) {
//		for(int i = 0;i<topicsList.size(); i++ ) {
//			if( topicsList.get(i).getId() == id) {
//				topicsList.remove(i);
//				return true;
//			}
//		}
		
		topicRepository.deleteById(id);
		return true;
	}

}
