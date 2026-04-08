package com.digitaltherapyassistant.service;

import com.digitaltherapyassistant.dto.Achievement;
import com.digitaltherapyassistant.dto.BurnoutRecovery;
import com.digitaltherapyassistant.dto.MonthlyTrends;
import com.digitaltherapyassistant.dto.WeeklySummary;

import java.util.List;
import java.util.UUID;

public interface ProgressService {

    WeeklySummary getWeeklySummary(UUID userId);

    MonthlyTrends getMonthlyTrends(UUID userId);

    BurnoutRecovery getBurnoutRecovery(UUID userId);

    List<Achievement> getAchievements(UUID userId);
}
