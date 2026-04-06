package com.digitaltherapyassistant.repository;

import com.digitaltherapyassistant.entity.ChatMessage;
import com.digitaltherapyassistant.entity.Status;
import com.digitaltherapyassistant.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSessionRepository extends JpaRepository<UserSession, UUID> {

    List<UserSession> findByUserIdOrderByStartedAtDescLimit3(UUID userId) ;

//    List<U>

    Optional<Integer> findCountFindByUserIdAndWhereStausIsCompleted(UUID userId) ;

    Optional<UserSession> findFirstByUserIdAndStatusOrderByStartedAtDesc(UUID userId, Status status);
}