package com.bytearchitect.service;

import com.bytearchitect.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();
    Topic getTopicById(String id);
    void addTopic(Topic topic);
    void updateTopic(String id, Topic topic);
    void deleteTopic(String id);
}
