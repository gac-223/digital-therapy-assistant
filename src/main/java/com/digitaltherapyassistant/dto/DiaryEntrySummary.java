package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DiaryEntrySummary {

    private UUID id;
    private String situation;
    private String automaticThought;
    private Integer moodBefore;
    private Integer moodAfter;
    private List<String> distortionNames;
    private LocalDateTime createdAt;
}
