package com.digitaltherapyassistant.dto;

import com.digitaltherapyassistant.entity.EmotionRating;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DiaryEntryDetail {

    private UUID id;
    private String situation;
    private String automaticThought;
    private List<EmotionRating> emotions;
    private List<DistortionSummary> distortions;
    private String alternativeThought;
    private Integer moodBefore;
    private Integer moodAfter;
    private Integer beliefRatingBefore;
    private Integer beliefRatingAfter;
    private LocalDateTime createdAt;

    @Data
    @AllArgsConstructor
    public static class DistortionSummary {
        private String id;
        private String name;
        private String description;
    }
}
