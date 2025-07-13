package com.bytearchitect.service.impl;

import com.bytearchitect.model.Topic;
import com.bytearchitect.repository.TopicRepository;
import com.bytearchitect.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(String id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
