package io.nazar;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Morse {
    private final HashMap<Character, String> morse = new HashMap<>();

    public Morse() {
        morse.put('A', ".-");
        morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D', "-..");
        morse.put('E', ".");
        morse.put('F', "..-.");
        morse.put('G', "--.");
        morse.put('H', "....");
        morse.put('I', "..");
        morse.put('J', ".---");
        morse.put('K', "-.-");
        morse.put('L', ".-..");
        morse.put('M', "--");
        morse.put('N', "-.");
        morse.put('O', "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S', "...");
        morse.put('T', "-");
        morse.put('U', "..-");
        morse.put('V', "...-");
        morse.put('W', ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");
    }
    public HashMap<Character, String> getMorse() {
        return morse;
    }

    public List<String> findSentences(List<String> dictionary, String message) {
        List<String> results = new ArrayList<>();
        search(dictionary, message, "", results);
        return results;
    }

    private void search(List<String> dictionary, String remaining,
                        String sentence, List<String> results) {
        if (remaining.isEmpty()) {
            results.add(sentence);
            return;
        }

        for (String entry : dictionary) {
            String word = entry.trim().toLowerCase();
            if (word.isEmpty()) {
                continue;
            }

            String code = "";
            for (char letter : word.toUpperCase().toCharArray()) {
                code += morse.get(letter);
            }

            if (remaining.startsWith(code)) {
                String nextSentence;

                if (sentence.isEmpty()) {
                    nextSentence = word;
                } else {
                    nextSentence = sentence + " " + word;
                }
                search(dictionary, remaining.substring(code.length()), nextSentence, results);
            }
        }
    }
}
