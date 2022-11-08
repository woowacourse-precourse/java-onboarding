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
        if(Character.isAlphabetic(c)) {
            return convertAlphaInReverse(c);
        }
        return c;
    }

    private static char convertAlphaInReverse(char c) {
        if(Character.isUpperCase(c)) {
            return (char)('A' + ('Z' - c));
        }
        return (char)('a' + ('z'- c));
    }
}
