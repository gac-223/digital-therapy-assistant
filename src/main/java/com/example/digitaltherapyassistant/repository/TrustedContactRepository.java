package com.example.digitaltherapyassistant.repository;

import com.example.digitaltherapyassistant.entity.TrustedContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrustedContactRepository extends JpaRepository<TrustedContact, UUID> {

}