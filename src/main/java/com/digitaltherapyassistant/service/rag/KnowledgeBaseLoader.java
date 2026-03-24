package com.digitaltherapyassistant.service.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        List<Document> documents = new ArrayList<>() ;

        // 1. Load Distortions
        documents.add(this.loadDistortions()) ;

        // 2. Load CBT techniques
        documents.add(this.loadCbtTechniques()) ;

        // 3. Load Crisis Protocols
        documents.add(this.loadCrisisProtocols()) ;

        System.out.println("Knowledge base loaded: " + totalLoaded + " total documents in vector store");

        if (vectorStore instanceof SimpleVectorStore svs) {
            storeFile.getParentFile().mkdirs();
            svs.save(storeFile);
            System.out.println("Vector store persisted to: " + storeFile.getAbsolutePath());
        }
    }


    private List<Document> loadDistortions() {
        List<Document> documents = new ArrayList<>() ;

        return documents ;
    }

    private List<Document> loadCbtTechniques() {
        List<Document> documents = new ArrayList<>() ;

        return documents ;
    }

    private List<Document> loadCrisisProtocols() {
        List<Document> documents = new ArrayList<>() ;

        return documents ;
    }



}