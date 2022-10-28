package onboarding;

import java.util.Map;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        Map<String, String> alphabet_map = new HashMap<>(){{
            put("A", "Z");
            put("B", "Y");
            put("C", "X");
            put("D", "W");
            put("E", "V");
            put("F", "U");
            put("G", "T");
            put("H", "S");
            put("I", "R");
            put("J", "Q");
            put("K", "P");
            put("L", "O");
            put("M", "N");
            put("N", "M");
            put("O", "L");
            put("P", "K");
            put("Q", "J");
            put("R", "I");
            put("S", "H");
            put("T", "G");
            put("U", "F");
            put("V", "E");
            put("W", "D");
            put("X", "C");
            put("Y", "B");
            put("Z", "A");
        }};
        String answer = "";
        String[] string_array = word.split("");
        for (String _alphabet: string_array) {
            String alphabet = _alphabet;
            if (!Character.isAlphabetic(alphabet.charAt(0))) {
                answer += alphabet;
                continue;
            }
            boolean is_upper_case = true;
            if (Character.isLowerCase(alphabet.charAt(0))) {
                is_upper_case = false;
                alphabet = _alphabet.toUpperCase();
            }

            String replace_alphabet = alphabet_map.get(alphabet);
            if (is_upper_case) {
                answer += replace_alphabet;
                continue;
            }
            answer += replace_alphabet.toLowerCase();
        }
        return answer;
    }
}
