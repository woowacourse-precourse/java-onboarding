package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char c: word.toCharArray()) {
            answer.append(reverseWord(c));
        }

        return answer.toString();
    }

    private static Character reverseWord(char character) {
        if (character >= 'A' && character <= 'Z') {
            return (char)('Z' + 'A' - character);
        } else if (character >= 'a' && character <= 'z') {
            return (char)('z' + 'a' - character);
        }
        return character;
    }
}
