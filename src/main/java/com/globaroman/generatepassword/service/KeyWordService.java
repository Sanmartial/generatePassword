package com.globaroman.generatepassword.service;

import com.globaroman.generatepassword.model.entity.KeyWord;
import com.globaroman.generatepassword.model.repository.KeyWordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyWordService {
    private final KeyWordRepository keyWordRepository;

    @Autowired
    public KeyWordService(KeyWordRepository keyWordRepository) {
        this.keyWordRepository = keyWordRepository;
    }

    public KeyWord createKeyWord(KeyWord keyWord) {
        return keyWordRepository.save(keyWord);
    }

    public List<KeyWord> getAllKeyWords() {
        return keyWordRepository.findAll();
    }

    public KeyWord getWordbyId(Long id) {
        return keyWordRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Word nor found"));
    }

    public long countElement() {
        return keyWordRepository.count();
    }
}
