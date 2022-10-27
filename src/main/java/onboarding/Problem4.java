package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                sb.append((char) ('Z' - (letter - 'A')));
                continue;
            }
            if (Character.isLowerCase(letter)) {
                sb.append((char) ('z' - (letter - 'a')));
                continue;
            }
            sb.append(letter);
        }
        return sb.toString();
    }
}
