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

        return answer;
    }

    public static void main(String[] args) {
        String sample = "I love you";

        System.out.println(solution(sample));
    }
}
