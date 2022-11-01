package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    private static final int EMPTY = 32;
    private static final int UPPER_A = 65;
    private static final int UPPER_Z = 90;
    private static final int LOWER_a = 97;
    private static final int LOWER_z = 122;
    private static final int A_Z = 155;
    private static final int a_z = 219;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        List<Character> wordList = word.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toList());
        char UPPER_CASE = (char) A_Z;
        char LOWER_CASE = (char) a_z;
        for (char alphabet : wordList) {
            if (alphabet == EMPTY) {
                answer.append(" ");
            }
            if (alphabet >= UPPER_A && alphabet <= UPPER_Z) {
                alphabet = (char) (UPPER_CASE - alphabet);
                answer.append(alphabet);
            }
            if (alphabet >= LOWER_a && alphabet <= LOWER_z) {
                alphabet = (char) (LOWER_CASE - alphabet);
                answer.append(alphabet);
            }
        }

        return answer.toString();
    }
}
