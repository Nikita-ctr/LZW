package com.nik.lzw;

public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        LZW lzw = new LZW(dictionary);
        lzw.compress();
        lzw.decompress();
    }
}
