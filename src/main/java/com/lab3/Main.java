package com.lab3;
import java.util.*;

/**
 * В каждой строке текста найти слово, в котором число различных символов минимально.
 * Слово может содержать буквы и цифры. Если таких слов несколько, вывести первое из них.
 * Вывести в формате: строка -> слово: кол-во_различных_символов
 * Например, для строки “ab ffff 1234 f jksk” -> ffff: 1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter text(double Enter to finish):");
        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            int lineInd = 0;
            while (!(line = scanner.nextLine()).isEmpty()) {
                System.out.println(line + " -> " + lineInd + " : " + wordWithLeastUniqueSymbols(line));
                ++lineInd;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int countUniqueSymbols(String word) {
        Set<Character> charSet = new HashSet<>();
        char[] charArr = word.toLowerCase().toCharArray();
        for (Character ch : charArr) {
            charSet.add(ch);
        }
        return charSet.size();
    }

    public static String wordWithLeastUniqueSymbols(String line) {
        line = line.trim();
        String[] words = line.split(" +");
        String minWord = "";
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
