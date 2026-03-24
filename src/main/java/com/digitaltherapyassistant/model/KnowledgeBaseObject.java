package com.digitaltherapyassistant.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class KnowledgeBaseObject {

    @Getter
    @Setter
    private String id ;

    @Getter
    @Setter
    private String name ;

    @Getter
    @Setter
    private String description ;

    @Getter
    @Setter
    private List<String> examples ;

    @Getter
    @Setter
    private List<String> reframingQuestions ;

    public KnowledgeBaseObject(String id, String name, String description, List<String> examples, List<String> reframingQuestions) {
        this.id = id ;
        this.name = name ;
        this.description = description ;
        this.examples = examples ;
        this.reframingQuestions = reframingQuestions ;
    }
}
