package com.digitaltherapyassistant.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Distortion extends KnowledgeBaseObject {

    public Distortion(String id, String name, String description, List<String> examples, List<String> reframingQuestions) {
        super(id, name, description, examples, reframingQuestions);
    }
}
