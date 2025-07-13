package com.bytearchitect.controller;
import com.bytearchitect.model.Topic;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private static final Map<Integer,Topic> topicStore = new HashMap<>();

    // Prepopulate with dummy data
    static {
        topicStore.put(1, new Topic(1, "REST API Design", "Learn REST fundamentals"));
        topicStore.put(2, new Topic(2, "System Design", "Distributed systems, scalability, etc."));
    }
    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable int id){
        return topicStore.get(id); // we will handle 404s
    }

    @GetMapping
    public List<Topic> getAllTopics(){
        return new ArrayList<>(topicStore.values());
    }
}