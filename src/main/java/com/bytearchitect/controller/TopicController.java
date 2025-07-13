package com.bytearchitect.controller;

import com.bytearchitect.dto.PagedResponse;
import com.bytearchitect.dto.TopicDTO;
import com.bytearchitect.model.Topic;
import com.bytearchitect.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public PagedResponse<TopicDTO> getAllTopics(Pageable pageable) {
        return topicService.getAllTopics(pageable);
    }

    @GetMapping("/{id}")
    public TopicDTO getTopicById(@PathVariable int id) {
        return topicService.getTopicById(id);
    }

    @PostMapping("/addTopic")
    public void addTopic(@Valid @RequestBody TopicDTO topic) {
        topicService.addTopic(topic);
    }

    @PostMapping("/addTopics")
    public void addTopics( @RequestBody List<@Valid TopicDTO> topicDTOList){
        topicService.addTopics(topicDTOList);
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable int id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
    }
}
