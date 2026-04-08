package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BurnoutRecovery {

    private String severityLevel;
    private int recoveryProgressPercent;
    private long totalSessionsCompleted;
    private int streakDays;
    private List<String> recommendations;
}
