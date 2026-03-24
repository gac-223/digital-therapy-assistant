package com.digitaltherapyassistant.service.interfaces;

import org.springframework.ai.chat.model.ChatResponse;

import java.util.List;
import java.util.UUID;

public interface AiServiceInterface {
    ChatResponse generateResponse(UUID sessionId, String userMessage) ;

    List<DistortionSuggestion> analyzeThough(String automaticThought) ;

    List<String> generateReframingPrompts(String thought, List<String> distortionIds) ;

    CrisisDetectionResult detectCrisis(String text) ;

    DiaryInsights generateInsights(UUID userId) ;

    SessionSummary summarizeSession(UUID sessionId) ;

}

