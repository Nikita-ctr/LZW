package com.nik.lzw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private final static String FILENAME = "default.txt";

    private final static String COMPRESSED = "compressed.lzw";

    private final static String DECOMPRESSED = "decompressed.txt";


    public static void write(String result) {
        try (BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(DECOMPRESSED))) {
            fileOutputStream.write(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static char[] read() {
        StringBuilder sb = new StringBuilder();
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(FILENAME))) {
            int c;
            while ((c = inputStream.read()) != -1) {
                sb.append(((char) c));
            }
            return sb.toString().toCharArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeListToFile(List<Integer> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMPRESSED))) {
            for (Integer integer : list) {
                oos.writeShort(integer.shortValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Short> readListFromFile() {
        List<Short> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COMPRESSED))) {
            while (true) {
                try {
                    short value = ois.readShort();
                    list.add(value);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
