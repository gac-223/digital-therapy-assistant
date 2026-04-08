package com.digitaltherapyassistant.controller;

import com.digitaltherapyassistant.dto.Achievement;
import com.digitaltherapyassistant.dto.BurnoutRecovery;
import com.digitaltherapyassistant.dto.MonthlyTrends;
import com.digitaltherapyassistant.dto.WeeklySummary;
import com.digitaltherapyassistant.service.ProgressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
@RequiredArgsConstructor
@Slf4j
public class ProgressController {

    private final ProgressService progressService;

    /**
     * GET /progress/weekly
     * Returns this week's session count, diary entries, mood improvement, and streak.
     */
    @GetMapping("/weekly")
    public ResponseEntity<WeeklySummary> getWeeklySummary(@RequestParam String userId) {
        log.debug("GET /progress/weekly userId={}", userId);
        return ResponseEntity.ok(progressService.getWeeklySummary(userId));
    }

    /**
     * GET /progress/monthly
     * Returns a 4-week breakdown of sessions, entries, and mood trends.
     */
    @GetMapping("/monthly")
    public ResponseEntity<MonthlyTrends> getMonthlyTrends(@RequestParam String userId) {
        log.debug("GET /progress/monthly userId={}", userId);
        return ResponseEntity.ok(progressService.getMonthlyTrends(userId));
    }

    /**
     * GET /progress/burnout
     * Returns burnout severity, recovery progress percentage, and recommendations.
     */
    @GetMapping("/burnout")
    public ResponseEntity<BurnoutRecovery> getBurnoutRecovery(@RequestParam String userId) {
        log.debug("GET /progress/burnout userId={}", userId);
        return ResponseEntity.ok(progressService.getBurnoutRecovery(userId));
    }

    /**
     * GET /progress/achievements
     * Returns a list of achievements and which are unlocked for the user.
     */
    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAchievements(@RequestParam String userId) {
        log.debug("GET /progress/achievements userId={}", userId);
        return ResponseEntity.ok(progressService.getAchievements(userId));
    }
}
