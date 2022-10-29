package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if (word.length() <= 1000) {
            List<Character> wordList = word.chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toList());
            char UPPER_CASE = (char) 155;
            char LOWER_CASE = (char) 219;
            for (int i = 0; i < wordList.size(); i++) {
                char c = wordList.get(i);
                if (c == 32) {
                    answer += " ";
                }
                if (c >= 65 && c <= 90) {
                    c = (char) (UPPER_CASE - c);
                    answer += String.valueOf(c);
                }
                if (c >= 97 && c <= 122) {
                    c = (char) (LOWER_CASE - c);
                    answer += String.valueOf(c);
                }
            }
        }
        return answer;
    }
}
