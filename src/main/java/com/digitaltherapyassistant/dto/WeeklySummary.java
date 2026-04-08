package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeeklySummary {

    private int sessionsCompleted;
    private int diaryEntries;
    private double averageMoodImprovement;
    private int streakDays;
    private String message;
}
