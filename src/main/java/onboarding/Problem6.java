package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");



        return answer;
    }

    public static boolean checkRepeated(String longerWord, String shorterWord) {

        for (int i = 0; i < shorterWord.length()-1; i++) {

            if (longerWord.contains(shorterWord.substring(i, i + 2))) {
                return true;
            }

        }

        return false;
    }

    public static List<String> sortedByWordLength(String word1, String word2) {
        List<String> sortedWord = new ArrayList<>();

        if (word1.length() >= word2.length()) {
            sortedWord.add(word2);
            sortedWord.add(word1);
            return sortedWord;
        }

        sortedWord.add(word1);
        sortedWord.add(word2);
        return sortedWord;
    }
}
