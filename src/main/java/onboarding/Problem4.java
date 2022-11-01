package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        List<Character> wordList = word.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());
        char UPPER_CASE = (char) 155;
        char LOWER_CASE = (char) 219;
        for (char alphabet : wordList) {
            if (alphabet == 32) {
                answer.append(" ");
            }
            if (alphabet >= 65 && alphabet <= 90) {
                alphabet = (char) (UPPER_CASE - alphabet);
                answer.append(String.valueOf(alphabet));
            }
            if (alphabet >= 97 && alphabet <= 122) {
                alphabet = (char) (LOWER_CASE - alphabet);
                answer.append(String.valueOf(alphabet));
            }
        }

        return answer.toString();
    }
}
