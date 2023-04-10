package com.nik.lzw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LZW {

    private final Dictionary dictionary;

    public LZW(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void compress() {

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> current = dictionary.compressDictionary();
        char[] characters = FileUtils.read();

        String foundChars = "";
        for (char character : characters) {
            String charsToAdd = foundChars + character;
            if (current.containsKey(charsToAdd)) {
                foundChars = charsToAdd;
            } else {
                result.add(current.get(foundChars));
                current.put(charsToAdd, current.size() + 1);
                foundChars = String.valueOf(character);
            }
        }

        FileUtils.writeListToFile(result);
    }

    public void decompress() {
        List<Short> encoded = FileUtils.readListFromFile();

        Map<Integer, String> dec = dictionary.decompressDictionary();
        String characters = String.valueOf((char) encoded.remove(0).intValue());
        StringBuilder result = new StringBuilder(characters);
        for (int code : encoded) {
            String entry = dec.containsKey(code) ? dec.get(code)
                    : characters + characters.charAt(0);
            result.append(entry);
            dec.put(dec.size() + 1, characters + entry.charAt(0));
            characters = entry;
        }
        FileUtils.write(String.valueOf(result));
    }
}
