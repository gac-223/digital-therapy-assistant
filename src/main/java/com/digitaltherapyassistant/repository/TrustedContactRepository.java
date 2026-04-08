package com.digitaltherapyassistant.repository;

import com.digitaltherapyassistant.entity.TrustedContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrustedContactRepository extends JpaRepository<TrustedContact, String> {

}