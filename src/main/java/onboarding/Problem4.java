package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(searchDictionary(word.charAt(i)));
        }
        return sb.toString();
    }

    private static Character searchDictionary(char c) {
        if (Character.isUpperCase(c)) {
            return (char) ('Z' - c + 'A');
        }
        if (Character.isLowerCase(c)) {
            return (char) ('z' - c + 'a');
        }
        return c;
    }
}
