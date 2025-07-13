package com.bytearchitect.controller;

import com.bytearchitect.dto.TopicDTO;
import com.bytearchitect.model.Topic;
import com.bytearchitect.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public TopicDTO getTopicById(@PathVariable int id) {
        return topicService.getTopicById(id);
    }

    @PostMapping
    public void addTopic(@Valid @RequestBody TopicDTO topic) {
        topicService.addTopic(topic);
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
