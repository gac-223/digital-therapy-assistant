package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistortionSuggestion {

    private String distortionId;
    private String name;
    private double confidence;
    private String reasoning;
}
