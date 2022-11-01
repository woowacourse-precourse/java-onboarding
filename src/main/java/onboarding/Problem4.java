package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Character> alphabetASC = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        List<Character> alphabetDESC = new ArrayList<>(Arrays.asList('Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q',
                'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'));

        StringBuilder answer = new StringBuilder();
        char[] alphabets = word.toCharArray();

        for (char alphabet : alphabets) {
            if (alphabet != ' ') {
                if (Character.isLowerCase(alphabet)) {
                    answer.append(Character.toLowerCase(alphabetDESC.get(alphabetASC.indexOf(
                            Character.toUpperCase(alphabet)))));
                } else {
                    answer.append(alphabetDESC.get(alphabetASC.indexOf(alphabet)));
                }
            } else {
                answer.append(' ');
            }
        }
        return String.valueOf(answer);
    }

}
