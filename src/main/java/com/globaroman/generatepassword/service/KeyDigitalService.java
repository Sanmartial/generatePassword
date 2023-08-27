package com.globaroman.generatepassword.service;

import com.globaroman.generatepassword.model.entity.KeyDigital;
import com.globaroman.generatepassword.model.repository.KeyDigitalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyDigitalService {
    private final KeyDigitalRepository keyDigitalRepository;

    @Autowired
    public KeyDigitalService(KeyDigitalRepository keyDigitalRepository) {
        this.keyDigitalRepository = keyDigitalRepository;
    }

    public KeyDigital createKeyDigital(KeyDigital keyDigital) {
        return keyDigitalRepository.save(keyDigital);
    }

    public List<KeyDigital> getAllKeyDigital() {
        return keyDigitalRepository.findAll();
    }

    public KeyDigital getRandomDigital() {
        Long id = (long) (Math.random() * 10000);
        return keyDigitalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Digital not found"));
    }
}
