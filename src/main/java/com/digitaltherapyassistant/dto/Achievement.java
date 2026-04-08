package com.digitaltherapyassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Achievement {

    private String id;
    private String title;
    private String description;
    private boolean unlocked;

    public static List<Achievement> allAchievements(long sessionsCompleted, int diaryEntries, int streakDays) {
        return List.of(
            new Achievement("first_session",    "First Step",          "Complete your first CBT session",      sessionsCompleted >= 1),
            new Achievement("five_sessions",    "Building Momentum",   "Complete 5 CBT sessions",              sessionsCompleted >= 5),
            new Achievement("ten_sessions",     "Dedicated Learner",   "Complete 10 CBT sessions",             sessionsCompleted >= 10),
            new Achievement("first_entry",      "Voice Your Thoughts", "Write your first diary entry",         diaryEntries >= 1),
            new Achievement("ten_entries",      "Reflective Mind",     "Write 10 diary entries",               diaryEntries >= 10),
            new Achievement("streak_7",         "Week Warrior",        "Maintain a 7-day streak",              streakDays >= 7),
            new Achievement("streak_30",        "Monthly Master",      "Maintain a 30-day streak",             streakDays >= 30)
        );
    }
}
