package com.digitaltherapyassistant.service;

import com.digitaltherapyassistant.dto.Achievement;
import com.digitaltherapyassistant.dto.BurnoutRecovery;
import com.digitaltherapyassistant.dto.MonthlyTrends;
import com.digitaltherapyassistant.dto.WeeklySummary;

import java.util.List;

public interface ProgressService {

    WeeklySummary getWeeklySummary(String userId);

    MonthlyTrends getMonthlyTrends(String userId);

    BurnoutRecovery getBurnoutRecovery(String userId);

    List<Achievement> getAchievements(String userId);
}
