package onboarding;

import java.util.HashMap;

public class Problem4 {

    private static final int ALPHABET_SIZE = 26;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Character> reverseDictionary = new HashMap<>();

        makeDictionary(reverseDictionary);

        for (char c : word.toCharArray()) {
            answer.append(reverseDictionary.get(c));
        }
        return answer.toString();
    }

    private static void makeDictionary(HashMap<Character, Character> reverseDictionary) {
        int temp = 1;
        reverseDictionary.put(' ', ' ');
        for (char i = 'A'; i <= 'z'; i++) {
            if ('Z' < i && i < 'a') {
                temp = 1;
                continue;
            }
            reverseDictionary.put(i, (char) (i + (ALPHABET_SIZE - temp)));
            temp += 2;
        }
    }
}
