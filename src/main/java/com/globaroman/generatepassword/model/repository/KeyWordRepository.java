package com.globaroman.generatepassword.model.repository;

import com.globaroman.generatepassword.model.entity.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordRepository extends JpaRepository<KeyWord, Long> {
}
