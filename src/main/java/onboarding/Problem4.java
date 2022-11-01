package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    private static final int BLANK = 32;

    public static String solution(String word) {
        return reverse(word);
    }

    private static String reverse(String word) {
        StringBuilder answer = new StringBuilder();
        List<Character> characters = convertToList(word);

        for (Character character : characters) {
            answer.append(findReverseCharacter(character));
        }
        return answer.toString();
    }

    private static char[] findReverseCharacter(Character character) {
        if (Character.isUpperCase(character)) {
            int n = 155 - character;
            return Character.toChars(n);
        }
        if (Character.isLowerCase(character)) {
            int n = 219 - character;
            return Character.toChars(n);
        }
        return Character.toChars(BLANK);
    }

    private static List<Character> convertToList(String word) {
        return word.chars().mapToObj(w -> (char)w).collect(Collectors.toList());
    }
}
