package com.digitaltherapyassistant.model;

import java.util.List;

public class CbtTechniques extends  KnowledgeBaseObject{
    public CbtTechniques(String id, String name, String description, List<String> examples, List<String> reframingQuestions) {
        super(id, name, description, examples, reframingQuestions);
    }
}
