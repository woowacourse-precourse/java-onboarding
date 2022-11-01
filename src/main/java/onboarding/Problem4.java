package onboarding;

public class Problem4 {
    private static char convertLetter(char alpha) {
        if (alpha >= 'A' && alpha <= 'Z') {
            return (char) ('A' + 'Z' - alpha);
        }
        if (alpha >= 'a' && alpha <= 'z') {
            return (char) ('a' + 'z' - alpha);
        }
        return alpha;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
