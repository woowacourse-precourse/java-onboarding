package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result;
        List<Character> charWordList = cryptogram.chars()
                .mapToObj(oneWord -> (char) oneWord).collect(Collectors.toList());
        return getWord(charWordList);
    }

    static String getWord(List<Character> word) {
        for (int i = word.size(); i > 1; i--) {
            for (int j = word.size() - 1; j > 0; j--) {
                if (word.get(j) == word.get(j - 1)) {
                    word.remove(j - 1);
                    word.remove(j - 1);
                }
            }
        }
        return word.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
