package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseAlphabetic(word);
    }

    private static String reverseAlphabetic(String word) {
        StringBuilder sb = new StringBuilder();
        word.chars()
                .mapToObj(i -> (char) i)
                .forEach(c -> {
                    if (isUppercase(c))
                        sb.append((char) ('Z' + 'A' - c));
                    else if (isLowercase(c))
                        sb.append((char) ('z' + 'a' - c));
                    else
                        sb.append(c);
                });
        return sb.toString();
    }

    private static boolean isUppercase(char c) {
        return 65 <= c && c <= 90;
    }

    private static boolean isLowercase(char c) {
        return 97 <= c && c <= 122;
    }
}