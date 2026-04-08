package com.digitaltherapyassistant.dto;

import com.digitaltherapyassistant.entity.EmotionRating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class DiaryEntryCreate {

    @NotBlank(message = "Situation is required")
    private String situation;

    @NotBlank(message = "Automatic thought is required")
    private String automaticThought;

    private List<EmotionRating> emotions;

    private List<String> distortionIds;

    private String alternativeThought;

    @Min(value = 1, message = "Mood must be between 1 and 10")
    @Max(value = 10, message = "Mood must be between 1 and 10")
    private Integer moodBefore;

    @Min(value = 1, message = "Mood must be between 1 and 10")
    @Max(value = 10, message = "Mood must be between 1 and 10")
    private Integer moodAfter;

    @Min(value = 0, message = "Belief rating must be between 0 and 100")
    @Max(value = 100, message = "Belief rating must be between 0 and 100")
    private Integer beliefRatingBefore;

    @Min(value = 0, message = "Belief rating must be between 0 and 100")
    @Max(value = 100, message = "Belief rating must be between 0 and 100")
    private Integer beliefRatingAfter;
}
