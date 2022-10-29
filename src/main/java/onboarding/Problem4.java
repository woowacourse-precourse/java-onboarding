package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = likeReverseFrog(word);
        return answer;
    }

    private static String likeReverseFrog(String word) {
        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String dictionary = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        List<String> dictionaryList = new ArrayList<>(List.of(dictionary.split("")));

        List<String> wordList = new ArrayList<>(List.of(word.split("")));

        for (String text : wordList) {
            if(" ".equals(text)) {
                result.append(" ");
                continue;
            }
            int idx = alphabet.indexOf(text.toLowerCase());
            result.append(dictionaryList.get(idx));
        }

        return result.toString();
    }
}