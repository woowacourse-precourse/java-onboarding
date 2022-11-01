package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                answer += (char) ('Z' - (c - 'A'));
            } else if (c >= 'a' && c <= 'z') {
                answer += (char) ('z' - (c - 'a'));
            } else {
                answer += c;
            }
        }
        return answer;
    }
}
