package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MonthlyTrends {

    private List<WeeklyStats> weeklyBreakdown;
    private List<String> topDistortionsThisMonth;
    private double overallMoodImprovement;
    private int totalSessionsThisMonth;
    private int totalEntriesThisMonth;

    @Data
    @AllArgsConstructor
    public static class WeeklyStats {
        private int weekNumber;
        private int sessionsCompleted;
        private int diaryEntries;
        private double averageMoodImprovement;
    }
}
