package com.example.digitaltherapyassistant.repository;

import com.example.digitaltherapyassistant.entity.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, UUID> {

}