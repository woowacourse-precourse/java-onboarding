package onboarding;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {
    public static char encryptCharacter(char alphabet) {
        if (isUpperCase(alphabet)) {
            alphabet = (char) ('A' + 'Z' - alphabet);
        }
        if (isLowerCase(alphabet)) {
            alphabet = (char) ('a' + 'z' - alphabet);
        }
        return alphabet;
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            answer.append(encryptCharacter(alphabet));
        }
        return answer.toString();
    }
}
