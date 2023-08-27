package com.globaroman.generatepassword.controller;

import com.globaroman.generatepassword.service.KeyDigitalService;
import com.globaroman.generatepassword.service.PasswordService;
import com.ibm.icu.text.Transliterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class WebController {
    private static final int DEFAULT_DIGITAL = 97643;

    private final KeyDigitalService keyDigitalService;
    private final PasswordService passwordService;

    @Autowired
    public WebController(KeyDigitalService keyDigitalService, PasswordService passwordService) {

        this.keyDigitalService = keyDigitalService;
        this.passwordService = passwordService;
    }

    private static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";


    @GetMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @PostMapping("/main")
    public String getGeneratePasswords(@RequestParam(value = "keywords1") String keywords1,
                                       @RequestParam(value = "keywords2") String keywords2, Model model) {
        String key1 = getTransliteratorString(keywords1);
        String key2 = getTransliteratorString(keywords2);
        int digit = keyDigitalService.getRandomDigital().getDigitKey();

        if (digit == 0) {
            digit = DEFAULT_DIGITAL;
        }

        if (key1.isBlank()) {
            key1 = passwordService.generateRandomWord();
        }

        if (key2.isBlank()) {
            key2 = passwordService.generateRandomWord();
        }
        List<String> listPasswords = passwordService.getListPasswords(key1, key2, digit);
        model.addAttribute("listPasswords", listPasswords);

        return "generate_passwords";
    }


    private String getTransliteratorString(String keywords) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        return toLatinTrans.transliterate(keywords);
    }


}

