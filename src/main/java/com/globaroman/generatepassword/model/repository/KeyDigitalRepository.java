package com.globaroman.generatepassword.model.repository;

import com.globaroman.generatepassword.model.entity.KeyDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyDigitalRepository extends JpaRepository<KeyDigital, Long> {
}
