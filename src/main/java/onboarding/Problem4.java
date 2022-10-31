package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                sb.append(convert(ch));
                continue;
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    private static char convert(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) ('A' + 'Z' - ch);
        }

        return (char) ('a' + 'z' - ch);
    }
}
