package com.nik.lzw;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public Map<String, Integer> compressDictionary() {
        Map<String, Integer> charMap = new HashMap<>();
        char[] chars = {'-', '/', '!', '"', '#', '$', '%', '&', '\'', '(', ')',
                '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
                '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~', ' ', 'ё', '\n',
                '\r', '\t', '—'};
        for (char c = 'A'; c <= 'z'; c++) {
            if (Character.isLetter(c)) {
                charMap.put(Character.toString(c), (int) c);
            }
        }
        for (char c = '0'; c <= '9'; c++) {
            charMap.put(Character.toString(c), (int) c);
        }
        for (char c = 0; c < chars.length; c++) {
            charMap.put(Character.toString(chars[c]), (int) chars[c]);
        }
        for (char c = 'А'; c <= 'я'; c++) {
            if (Character.isLetter(c)) {
                charMap.put(Character.toString(c), (int) c);
            }
        }
        return charMap;
    }

    public Map<Integer, String> decompressDictionary() {
        Map<Integer, String> outputMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : compressDictionary().entrySet()) {
            outputMap.put(entry.getValue(), entry.getKey());
        }
        return outputMap;
    }
}
