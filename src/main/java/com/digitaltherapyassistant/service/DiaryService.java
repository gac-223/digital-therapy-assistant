package com.digitaltherapyassistant.service;

import com.digitaltherapyassistant.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiaryService {

    DiaryEntryResponse createEntry(String userId, DiaryEntryCreate request);

    Page<DiaryEntrySummary> getEntries(String userId, Pageable pageable);

    DiaryEntryDetail getEntryDetail(String entryId);

    void deleteEntry(String entryId);

    List<DistortionSuggestion> suggestDistortions(String thought);

    DiaryInsights getInsights(String userId);
}
