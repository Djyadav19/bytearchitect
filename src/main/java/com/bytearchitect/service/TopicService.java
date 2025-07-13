package com.bytearchitect.service;

import com.bytearchitect.dto.TopicDTO;
import com.bytearchitect.model.Topic;

import java.util.List;

public interface TopicService {
    List<TopicDTO> getAllTopics();
    TopicDTO getTopicById(int id);
    void addTopic(TopicDTO topic);
    void updateTopic(int id, Topic topic);
    void deleteTopic(int id);
}
