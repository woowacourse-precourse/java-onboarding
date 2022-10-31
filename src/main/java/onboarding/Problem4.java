package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                answer.append((char) ('Z' - (c - 'A')));
            } else if (c >= 'a' && c <= 'z') {
                answer.append((char) ('z' - (c - 'a')));
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
