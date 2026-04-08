package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class DiaryEntrySummary {

    private String id;
    private String situation;
    private String automaticThought;
    private Integer moodBefore;
    private Integer moodAfter;
    private List<String> distortionNames;
    private LocalDateTime createdAt;
}
