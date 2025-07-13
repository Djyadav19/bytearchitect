package com.bytearchitect.service;

import com.bytearchitect.dto.PagedResponse;
import com.bytearchitect.dto.TopicDTO;
import com.bytearchitect.model.Topic;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface TopicService {
    PagedResponse<TopicDTO> getAllTopics(Pageable pageable);
    TopicDTO getTopicById(int id);
    void addTopic(TopicDTO topic);
    void updateTopic(int id, Topic topic);
    void deleteTopic(int id);

    void addTopics(@Valid List<TopicDTO> topicDTOList);
}
