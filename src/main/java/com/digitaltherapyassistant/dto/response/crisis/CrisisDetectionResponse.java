package com.digitaltherapyassistant.dto.response.crisis;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CrisisDetectionResponse {
    public static enum RiskLevel {
        NONE("None"),
        LOW("Low"),
        MEDIUM("Medium"),
        HIGH("High"),
        CRITICAL("Critical") ;

        private final String displayName ;

        private RiskLevel(String displayName) {this.displayName = displayName ; }

        @Override
        public String toString() {return this.displayName ;}

    }

    public static enum RecommendedAction {
        NONE("None"),
        SHOW_RESOURCES("Show Resources"),
        SHOW_CRISIS_HUB("Show Crisis Hub"),
        IMMEDIATE_INTERVENTION("Immediate Intervention") ;

        private final String displayName ;

        private RecommendedAction(String displayName) {this.displayName = displayName ; }

        @Override
        public String toString() {return this.displayName ;}
    }

    @NotBlank(message = "riskLevel required")
    private RiskLevel riskLevel ;

    @NotBlank(message = "detected keywords required")
    private List<String> keywordsDetected ;

    @NotBlank(message = "recommended action required")
    private RecommendedAction recommendedAction ;

    @NotBlank(message = "reasoning required")
    private String reasoning ;

}
