package com.digitaltherapyassistant.repository;

import com.digitaltherapyassistant.entity.DiaryEntry;
import com.digitaltherapyassistant.entity.CognitiveDistortion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, String> {

    Page<DiaryEntry> findByUserIdAndDeletedFalseOrderByCreatedAtDesc(String userId, Pageable pageable);

    List<DiaryEntry> findByUserIdAndDeletedFalse(String userId);

    // Find top distortions by user (returns [distortion, count] pairs)
    @Query("SELECT cd, COUNT(cd) as cnt FROM DiaryEntry de " +
           "JOIN de.distortions cd " +
           "WHERE de.user.id = :userId AND de.deleted = false " +
           "GROUP BY cd ORDER BY cnt DESC")
    List<Object[]> findTopDistortionsByUser(@Param("userId") String userId);

    // Calculate average mood improvement for a user
    @Query("SELECT AVG(de.moodAfter - de.moodBefore) FROM DiaryEntry de " +
           "WHERE de.user.id = :userId AND de.deleted = false " +
           "AND de.moodBefore IS NOT NULL AND de.moodAfter IS NOT NULL")
    Double calculateAverageMoodImprovement(@Param("userId") String userId);
}