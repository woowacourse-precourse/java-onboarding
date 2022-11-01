package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        List<Character> reversedChars = word.chars()
            .mapToObj(c -> reverseChar((char) c))
            .collect(Collectors.toList());

        for (char c: reversedChars) {
            answer.append(c);
        }

        return answer.toString();
    }

    private static boolean isAlphabet(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static char reverseChar(Character c) {
        if (!isAlphabet(c)) {
            return c;
        }
        char reversedChar = Character.isUpperCase(c) ?
            Character.toUpperCase(c) : Character.toLowerCase(c);
        return reverseAscii(reversedChar);
    }

    private static char reverseAscii(Character c) {
        int charIndex = c;
        int startIndex = Character.isUpperCase(c) ? 65 : 97;
        return (char) (charIndex + 25 - 2*(charIndex - startIndex));
    }
}
