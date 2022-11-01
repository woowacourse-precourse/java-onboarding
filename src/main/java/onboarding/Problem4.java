package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            char transformedLetter = transform(letter);
            result.append(transformedLetter);
        }
        return result.toString();
    }
    private static char transform(char ch) {
        if ('a' <= ch && ch <= 'z')
            return (char)('a' + 'z' - ch);

        if ('A' <= ch && ch <= 'Z')
            return (char)('A' + 'Z' - ch);

        return ch;
    }
}