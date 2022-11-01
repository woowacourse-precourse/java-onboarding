package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {

        StringBuilder reversedString = new StringBuilder();

        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);

            if (Character.isUpperCase(character)) {
                reversedString.append((char)('Z' - (character - 'A')));
            } else if (Character.isLowerCase(character)) {
                reversedString.append((char)('z' - (character - 'a')));
            } else {
                reversedString.append(character);
            }
        }

        String answer = reversedString.toString();
        return answer;
    }
}
