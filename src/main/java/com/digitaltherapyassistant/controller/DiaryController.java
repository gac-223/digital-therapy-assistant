package com.digitaltherapyassistant.controller;

import com.digitaltherapyassistant.dto.*;
import com.digitaltherapyassistant.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    private final DiaryService diaryService;

    /**
     * GET /diary/entries
     * List paginated diary entries for a user.
     * userId passed as a request param (will be extracted from JWT in full implementation).
     */
    @GetMapping("/entries")
    public ResponseEntity<Page<DiaryEntrySummary>> getEntries(
            @RequestParam String userId,
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {

        log.debug("GET /diary/entries userId={}", userId);
        Page<DiaryEntrySummary> entries = diaryService.getEntries(userId, pageable);
        return ResponseEntity.ok(entries);
    }

    /**
     * POST /diary/entries
     * Create a new diary entry.
     */
    @PostMapping("/entries")
    public ResponseEntity<DiaryEntryResponse> createEntry(
            @RequestParam String userId,
            @Valid @RequestBody DiaryEntryCreate request) {

        log.debug("POST /diary/entries userId={}", userId);
        DiaryEntryResponse response = diaryService.createEntry(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET /diary/entries/{entryId}
     * Get the full detail of a single diary entry.
     */
    @GetMapping("/entries/{entryId}")
    public ResponseEntity<DiaryEntryDetail> getEntryDetail(@PathVariable String entryId) {
        log.debug("GET /diary/entries/{}", entryId);
        DiaryEntryDetail detail = diaryService.getEntryDetail(entryId);
        return ResponseEntity.ok(detail);
    }

    /**
     * DELETE /diary/entries/{entryId}
     * Soft-delete a diary entry.
     */
    @DeleteMapping("/entries/{entryId}")
    public ResponseEntity<Void> deleteEntry(@PathVariable String entryId) {
        log.debug("DELETE /diary/entries/{}", entryId);
        diaryService.deleteEntry(entryId);
        return ResponseEntity.noContent().build();
    }

    /**
     * POST /diary/distortions/suggest
     * Ask the AI to suggest cognitive distortions for a given thought.
     */
    @PostMapping("/distortions/suggest")
    public ResponseEntity<List<DistortionSuggestion>> suggestDistortions(
            @RequestBody Map<String, String> body) {

        String thought = body.get("thought");
        if (thought == null || thought.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        log.debug("POST /diary/distortions/suggest thought={}", thought);
        List<DistortionSuggestion> suggestions = diaryService.suggestDistortions(thought);
        return ResponseEntity.ok(suggestions);
    }

    /**
     * GET /diary/insights
     * Return pattern insights derived from a user's diary entries.
     */
    @GetMapping("/insights")
    public ResponseEntity<DiaryInsights> getInsights(@RequestParam String userId) {
        log.debug("GET /diary/insights userId={}", userId);
        DiaryInsights insights = diaryService.getInsights(userId);
        return ResponseEntity.ok(insights);
    }
}
