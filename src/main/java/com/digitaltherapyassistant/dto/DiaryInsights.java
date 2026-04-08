package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DiaryInsights {

    private int totalEntries;
    private double averageMoodImprovement;
    private List<TopDistortion> topDistortions;
    private String summary;

    @Data
    @AllArgsConstructor
    public static class TopDistortion {
        private String distortionId;
        private String name;
        private int count;
    }
}
