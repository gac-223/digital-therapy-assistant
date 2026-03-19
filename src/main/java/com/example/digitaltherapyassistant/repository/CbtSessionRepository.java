package com.example.digitaltherapyassistant.repository;

import com.example.digitaltherapyassistant.entity.CbtSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CbtSessionRepository extends JpaRepository<CbtSession, UUID> {

}