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
import java.util.UUID;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
@Slf4j
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("/weekly")
    public ResponseEntity<WeeklySummary> getWeeklySummary(@RequestParam UUID userId) {
        log.debug("GET /progress/weekly userId={}", userId);
        return ResponseEntity.ok(progressService.getWeeklySummary(userId));
    }

    @GetMapping("/monthly")
    public ResponseEntity<MonthlyTrends> getMonthlyTrends(@RequestParam UUID userId) {
        log.debug("GET /progress/monthly userId={}", userId);
        return ResponseEntity.ok(progressService.getMonthlyTrends(userId));
    }

    @GetMapping("/burnout")
    public ResponseEntity<BurnoutRecovery> getBurnoutRecovery(@RequestParam UUID userId) {
        log.debug("GET /progress/burnout userId={}", userId);
        return ResponseEntity.ok(progressService.getBurnoutRecovery(userId));
    }

    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAchievements(@RequestParam UUID userId) {
        log.debug("GET /progress/achievements userId={}", userId);
        return ResponseEntity.ok(progressService.getAchievements(userId));
    }
}
