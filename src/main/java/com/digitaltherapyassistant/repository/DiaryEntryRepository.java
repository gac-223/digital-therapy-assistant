package com.digitaltherapyassistant.repository;

import com.digitaltherapyassistant.entity.CognitiveDistortion;
import com.digitaltherapyassistant.entity.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, UUID> {

    @Query(value = "SELECT dis FROM DiaryEntry d " +
                    "JOIN d.distortions dis " +
                    "WHERE d.user.id = :userId " +
                    "GROUP BY dis " +
                    "ORDER BY COUNT(dis) DESC " +
                    "LIMIT :limit")
    List<CognitiveDistortion> findTopDistortionsByUser(@Param("userId") UUID userId, @Param("limit") Integer limit) ;
}