package onboarding;

import java.util.HashMap;

public class Problem4 {
    static class ConvertAlphabet {
        HashMap<Character, Character> alphabet = new HashMap<Character, Character>();

        public ConvertAlphabet() {
            char upperAlphabetSerial = 65;
            char lowerAlphabetSerial = 97;

            for (int i = 0; i < 26; i++) {
                alphabet.put(upperAlphabetSerial, (char) (90 - i));
                alphabet.put(lowerAlphabetSerial, (char) (122 - i));

                upperAlphabetSerial++;
                lowerAlphabetSerial++;
            }
        }
    }
    public static String solution(String word) {
        ConvertAlphabet convertAlphabet = new ConvertAlphabet();
        StringBuilder stringBuilder = new StringBuilder(word);

        String answer = "";
        for (int i = 0; i < stringBuilder.length(); i++) {
            char isAlpha = stringBuilder.charAt(i);

            if (isAlpha >='A' && isAlpha <= 'Z' || isAlpha >= 'a' && isAlpha <= 'z') {
                char character =
                        convertAlphabet.alphabet.get(stringBuilder.charAt(i));
                answer += character;
            } else
                answer += stringBuilder.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String sample = "I love you";

        System.out.println(solution(sample));
    }
}
