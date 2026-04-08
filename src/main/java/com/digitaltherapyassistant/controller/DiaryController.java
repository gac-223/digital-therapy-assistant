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
import java.util.UUID;

@RestController
@RequestMapping("/api/diary")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping("/entries")
    public ResponseEntity<Page<DiaryEntrySummary>> getEntries(
            @RequestParam UUID userId,
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {

        log.debug("GET /diary/entries userId={}", userId);
        return ResponseEntity.ok(diaryService.getEntries(userId, pageable));
    }

    @PostMapping("/entries")
    public ResponseEntity<DiaryEntryResponse> createEntry(
            @RequestParam UUID userId,
            @Valid @RequestBody DiaryEntryCreate request) {

        log.debug("POST /diary/entries userId={}", userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(diaryService.createEntry(userId, request));
    }

    @GetMapping("/entries/{entryId}")
    public ResponseEntity<DiaryEntryDetail> getEntryDetail(@PathVariable UUID entryId) {
        log.debug("GET /diary/entries/{}", entryId);
        return ResponseEntity.ok(diaryService.getEntryDetail(entryId));
    }

    @DeleteMapping("/entries/{entryId}")
    public ResponseEntity<Void> deleteEntry(@PathVariable UUID entryId) {
        log.debug("DELETE /diary/entries/{}", entryId);
        diaryService.deleteEntry(entryId);
        return ResponseEntity.noContent().build();
    }   

    @PostMapping("/distortions/suggest")
    public ResponseEntity<List<DistortionSuggestion>> suggestDistortions(
            @RequestBody Map<String, String> body) {

        String thought = body.get("thought");
        if (thought == null || thought.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        log.debug("POST /diary/distortions/suggest thought={}", thought);
        return ResponseEntity.ok(diaryService.suggestDistortions(thought));
    }

    @GetMapping("/insights")
    public ResponseEntity<DiaryInsights> getInsights(@RequestParam UUID userId) {
        log.debug("GET /diary/insights userId={}", userId);
        return ResponseEntity.ok(diaryService.getInsights(userId));
    }
}
