package com.digitaltherapyassistant.model;

import java.util.List;

public class CrisisProtocol extends KnowledgeBaseObject {
    public CrisisProtocol(String id, String name, String description, List<String> examples, List<String> reframingQuestions) {
        super(id, name, description, examples, reframingQuestions);
    }
}
