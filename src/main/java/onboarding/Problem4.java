package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                answer.append(c);
                continue;
            }
            if (Character.isUpperCase(c)) {
                answer.append((char) ('Z' - c + 'A'));
            } else {
                answer.append((char) ('z' - c + 'a'));
            }
        }
        return answer.toString();
    }
}
