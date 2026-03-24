package com.digitaltherapyassistant.service;

import com.digitaltherapyassistant.service.interfaces.AiServiceInterface;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AiService implements AiServiceInterface {
    @Override
    public ChatResponse generateResponse(UUID sessionId, String userMessage) {
        return null;
    }

    @Override
    public List<DistortionSuggestion> analyzeThough(String automaticThought) {
        return null;
    }

    @Override
    public List<String> generateReframingPrompts(String thought, List<String> distortionIds) {
        return null;
    }

    @Override
    public CrisisDetectionResult detectCrisis(String text) {
        return null;
    }

    @Override
    public DiaryInsights generateInsights(UUID userId) {
        return null;
    }

    @Override
    public SessionSummary summarizeSession(UUID sessionId) {
        return null;
    }
}
