package com.digitaltherapyassistant.model;

import java.util.List;

public class BurnoutContent extends KnowledgeBaseObject{
    public BurnoutContent(String id, String name, String description, List<String> examples, List<String> reframingQuestions) {
        super(id, name, description, examples, reframingQuestions);
    }
}
