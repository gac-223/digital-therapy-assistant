package com.digitaltherapyassistant.service.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

public class KnowledgeBaseLoader {
    private final VectorStore vectorStore;
    private final String storePath;

    public KnowledgeBaseLoader(VectorStore vectorStore, @Value("${spring.ai.vectorstore.simple.store.path:./data/vectorstore.json}") String storePath) {
        this.vectorStore = vectorStore;
        this.storePath = storePath;
    }

    @PostConstruct
    public void loadKnowledgeBase() {
        File storeFile = new File(storePath);

        if (storeFile.exists() && storeFile.length() > 0) {
            System.out.println("Vector Store already persisted at " + storeFile.getAbsolutePath() + ". Skipping knowledge base reload.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        int totalLoaded = 0;

        // 1. Load Distortions
        // 2. Load CBT techniques
        // 3. Load Crisis Protocols

        System.out.println("Knowledge base loaded: " + totalLoaded + " total documents in vector store");

        if (vectorStore instanceof SimpleVectorStore svs) {
            storeFile.getParentFile().mkdirs();
            svs.save(storeFile);
            System.out.println("Vector store persisted to: " + storeFile.getAbsolutePath());
        }
    }
}