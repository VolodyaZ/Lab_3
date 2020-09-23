package com.lab3;

//В каждой строке текста найти слово, в котором число различных символов минимально.
// Слово может содержать буквы и цифры. Если таких слов несколько, вывести первое из них.
// Вывести в формате: строка -> слово: кол-во_различных_символов
//        Например, для строки “ab ffff 1234 f jksk” -> ffff: 1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static final String END_LINE = "";

    public static void main(String[] args) {
        System.out.println("Enter text(double Enter to finish):");
        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            int lineInd = 0;
            while (!(line = scanner.nextLine()).equals(END_LINE)) {
                System.out.println(line + " -> " + lineInd + " : " + leastNumOfUniqueSymbols(line));
                ++lineInd;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static ArrayList<String> parseLine(String line) {
        ArrayList<String> words = new ArrayList<>();
        line = line.trim();
        int index1 = 0;
        int index2 = line.indexOf(' ');
        String word;
        while (index2 != -1) {
            word = index1 == 0 ? line.substring(0, index2) : line.substring(index1 + 1, index2);
            if (!word.isEmpty()) {
                words.add(word);
            }
            index1 = index2;
            index2 = line.indexOf(' ', index1 + 1);
        }
        words.add(index1 == 0 ? line : line.substring(index1 + 1));
        return words;
    }

    private static int countUniqueSymbols(String word) {
        HashSet<Character> charSet = new HashSet<>();
        char[] charArr = word.toCharArray();
        for (Character ch : charArr) {
            charSet.add(Character.toLowerCase(ch));
        }
        return charSet.size();
    }

    public static String leastNumOfUniqueSymbols(String line) {
        ArrayList<String> words = parseLine(line);
        String minWord = null;
        int minCount = Integer.MAX_VALUE;
        int count;
        for (String word : words) {
            count = countUniqueSymbols(word);
            if (count < minCount) {
                minCount = count;
                minWord = word;
            }
        }
        return minWord;
    }
}
