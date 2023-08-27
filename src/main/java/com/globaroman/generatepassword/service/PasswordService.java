package com.globaroman.generatepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PasswordService {
    private final KeyWordService keyWordService;

    public PasswordService(KeyWordService keyWordService) {
        this.keyWordService = keyWordService;

    }

    private static final int PASSWORD_LENGTH = 10;
    Random random = new Random();

    public List<String> getListPasswords(String key1, String key2, int digit) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            list.add(generationPassword());
        }
        list.add(versionPassword1(key1, digit));
        list.add(versionPassword2(key1, digit));
        list.add(versionPassword3(key1, digit));
        list.add(versionPassword4(key1, digit));
        list.add(versionPassword5(key1, key2));
        list.add(versionPassword5(key1, key2));
        list.add(versionPassword5(key1, key2));
        list.add(versionPassword6(key1, digit));
        list.add(versionPassword7(key1, key2, digit));
        list.add(versionPassword7(key1, key2, digit));
        return list;
    }

    public String generateRandomWord() {
        StringBuilder sb1 = new StringBuilder();
        Long id = (random.nextLong(totalElementDataBase()));
        sb1.append(keyWordService.getWordbyId(id).getNameKeyword());
        return sb1.substring(0);
    }

    private String versionPassword1(String key1, int digit) {
        StringBuilder sb1 = new StringBuilder();
        char[] chOne = key1.toCharArray();
        char[] chTwo = String.valueOf(digit).toCharArray();
        for (int i = 0; i < chOne.length; i++) {
            if (i < chTwo.length)
                sb1.append(chOne[i]).append(chTwo[i]);
            else
                sb1.append(chOne[i]);
        }
        return sb1.substring(0);
    }

    private String versionPassword2(String key1, int digit) {
        StringBuilder sb1 = new StringBuilder();
        char[] chOne = key1.toCharArray();
        char[] chTwo = String.valueOf(digit).toCharArray();
        int dec = chTwo.length - 1;
        for (char c : chOne) {
            sb1.append(c);
            if (dec >= 0)
                sb1.append(chTwo[dec--]);
        }
        return sb1.substring(0);
    }

    private String versionPassword3(String key1, int digit) {
        StringBuilder sb1 = new StringBuilder();
        char[] chOne = key1.toCharArray();
        char[] chTwo = String.valueOf(digit).toCharArray();
        int dec = chOne.length - 1;
        for (int i = 0; i < chOne.length; i++) {
            if (dec >= 0)
                sb1.append(chOne[dec--]);
            if (i < chTwo.length)
                sb1.append(chTwo[i]);
        }
        return sb1.substring(0);
    }

    private String versionPassword4(String key1, int digit) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] ch = sb1.append(key1).append(digit).substring(0).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            sb2.append(ch[(random.nextInt(ch.length))]);

        }
        return sb2.substring(0);
    }

    private String versionPassword5(String key1, String key2) {
        StringBuilder sb1 = new StringBuilder();
        return sb1.append(key1).append("_").append(generateRandomWord()).append("_").append(key2).
                substring(0);
    }

    private String versionPassword6(String key2, int digit) {
        StringBuilder sb1 = new StringBuilder();
        return sb1.append(key2).append(digit).append(generateRandomWord()).substring(0);
    }

    private String versionPassword7(String key1, String key2, int digit) {
        StringBuilder sb1 = new StringBuilder();
        char[] ch = String.valueOf(digit).toCharArray();
        return sb1.append(key1).append(ch[0]).append(ch[1]).append(generateRandomWord()).append(ch[2]).append(ch[3]).append(key2).append(ch[4] + ch[0]).substring(0);
    }

    private String generationPassword() {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb1.append(getChar());
        }
        return sb1.substring(0);
    }

    private char getChar() {
        char ch = (char) random.nextInt(122);
        while (!Character.isLetterOrDigit(ch))
            ch = (char) (random.nextInt(122));
        return ch;
    }


    private long totalElementDataBase() {
        return keyWordService.countElement();
    }


}
