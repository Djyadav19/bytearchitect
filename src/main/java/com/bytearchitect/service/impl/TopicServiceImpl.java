package com.bytearchitect.service.impl;

import com.bytearchitect.dto.PagedResponse;
import com.bytearchitect.dto.TopicDTO;
import com.bytearchitect.exception.DuplicateResourceException;
import com.bytearchitect.exception.ResourceNotFoundException;
import com.bytearchitect.model.Topic;
import com.bytearchitect.repository.TopicRepository;
import com.bytearchitect.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository, ModelMapper modelMapper) {
        this.topicRepository = topicRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PagedResponse<TopicDTO> getAllTopics(Pageable pageable) {
        Page<Topic> topicPage = topicRepository.findAll(pageable);
        List<TopicDTO> topicDTOs = topicPage.stream()
                .map(topic -> modelMapper.map(topic, TopicDTO.class))
                .toList();
        return new PagedResponse<>(
                topicDTOs,
                topicPage.getNumber(),
                topicPage.getSize(),
                topicPage.getTotalElements(),
                topicPage.getTotalPages(),
                topicPage.isLast()
        );
    }

    @Override
    public TopicDTO getTopicById(int id) {
        Topic topic =  topicRepository.findById(String.valueOf(id)).orElseThrow(()->new ResourceNotFoundException("Item not found with id: "+id));
        return modelMapper.map(topic,TopicDTO.class);
    }

    @Override
    public void addTopic(TopicDTO topicdto) {
        /*Topic topic = new Topic(topicdto.getId(),
                topicdto.getTitle(),
                topicdto.getDescription()
                );*/
        if (topicRepository.existsById(String.valueOf(topicdto.getId()))) {
            throw new DuplicateResourceException("Topic with ID " + topicdto.getId() + " already exists");
        }
        Topic topic = modelMapper.map(topicdto,Topic.class);
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(int id, Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(int id) {
        topicRepository.deleteById(String.valueOf(id));
    }

    @Override
    public void addTopics(List<TopicDTO> topicDTOList) {
        StringBuilder errorMessage = new StringBuilder();
        /*for(TopicDTO topicdto : topicDTOList){
            if (topicRepository.existsById(String.valueOf(topicdto.getId()))) {
                errorMessage.append("Topic with ID " + topicdto.getId() + " already exists");
            }
            Topic topic = modelMapper.map(topicdto,Topic.class);
            topicRepository.save(topic);
            topicRepository.saveAll(topicDTOList.stream()
                    .map(dto-> modelMapper.map(dto,Topic.class))
                    .collect(Collectors.toList())
            );
        }*/
        topicRepository.saveAll(topicDTOList.stream()
                .map(dto-> modelMapper.map(dto,Topic.class))
                .collect(Collectors.toList())
        );
        if(errorMessage.length() > 0){
            throw new DuplicateResourceException(errorMessage.toString());
        }
    }
}
