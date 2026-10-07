package io.nazar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Morse morse = new Morse();
        String s = "--.--.---.......-.---.-.-.-..-.....--..-....-.-----..-";
        InputStream input = Main.class.getResourceAsStream("/words.txt");
        List<String> dictionary;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {
            dictionary = reader.lines().collect(Collectors.toList());
        }

        List<String> solutions = morse.findSentences(dictionary, s);
        solutions.forEach(System.out::println);
    }

}
