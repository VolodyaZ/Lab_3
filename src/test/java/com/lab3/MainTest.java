package com.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void test1() {
        String result = Main.wordWithLeastUniqueSymbols("ab ffff 1234 f jksk");
        String expected = "ffff";
        assertEquals(result, expected);
    }

    @Test
    void test2() {
        String result = Main.wordWithLeastUniqueSymbols("In computing line is unit of organization for text files");
        String expected = "In";
        assertEquals(result, expected);
    }

    @Test
    void doubleSpace() {
        String result = Main.wordWithLeastUniqueSymbols("  ab ffff  1234  f  jksk  ");
        String expected = "ffff";
        assertEquals(result, expected);
    }

    @Test
    void empty() {
        String result = Main.wordWithLeastUniqueSymbols("");
        String expected = "";
        assertEquals(result, expected);
    }

    @Test
    void upperCaseTest() {
        String result = Main.wordWithLeastUniqueSymbols("bcd Aa b");
        String expected = "Aa";
        assertEquals(result, expected);
    }
}