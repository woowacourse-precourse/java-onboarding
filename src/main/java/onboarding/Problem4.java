package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            sb.append(convertInReverse(word.charAt(i)));
        }
        String answer = sb.toString();
        return answer;
    }

    private static char convertInReverse(char c) {
        if(isAlpha(c)) {
            return convertAlphaInReverse(c);
        }
        return c;
    }

    private static char convertAlphaInReverse(char c) {
        if(isUpperCase(c)) {
            return (char)('A' + ('Z' - c));
        }
        return (char)('a' + ('z'- c));
    }

    private static boolean isAlpha(char c) {
        return isUpperCase(c) || isLowerCase(c);
    }
    private static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
}
