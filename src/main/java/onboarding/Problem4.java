package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(convertAlphabet(c));
        }
        return answer.toString();
    }

    private static char convertAlphabet(char c) {
        if (!isAlphabet(c)) {
            return c;
        }
        return convertChar(c);
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static char convertChar(char c) {
        if (Character.isUpperCase(c)) {
            return (char)('Z' - (c - 'A'));
        }
        return (char)('z' - (c - 'a'));
    }

}