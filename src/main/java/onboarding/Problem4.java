package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return treeFrog(word);
    }
    private static String treeFrog(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    stringBuilder.append((char) ('A' + 'Z' - c));
                }
                else {
                    stringBuilder.append((char) ('a' + 'z' - c));
                }
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}