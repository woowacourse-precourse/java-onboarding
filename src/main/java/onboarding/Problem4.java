package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            char transformedLetter = transform(letter);
            sb.append(transformedLetter);
        }
        return sb.toString();
    }
    private static char transform(char c) {
        if ('a' <= c && c <= 'z')
            return (char)('a' + 'z' - c);

        if ('A' <= c && c <= 'Z')
            return (char)('A' + 'Z' - c);

        return c;
    }
}