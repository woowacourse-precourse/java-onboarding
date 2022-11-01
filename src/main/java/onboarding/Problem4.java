package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                answer.append((char) ('a' + ('z' - ch)));
            } else if (Character.isUpperCase(ch)) {
                answer.append((char) ('A' + ('Z' - ch)));
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}
