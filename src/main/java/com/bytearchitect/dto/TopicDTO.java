package com.bytearchitect.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.logging.log4j.message.Message;

public class TopicDTO {

    private int id;

    @NotBlank()
    @Size(min = 3,max = 100, message = "Title must be 3-100 characters")
    private String title;
    private String description;

    public TopicDTO(){}

    public TopicDTO(int id, String title,String description){
        this.id = id;
        this.title = title;
        this.description  = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
