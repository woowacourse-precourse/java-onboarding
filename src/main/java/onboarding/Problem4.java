package onboarding;

public class Problem4 {

    public static char transform(char c) {

        if (c >= 'A' && c <= 'Z') {
            if (c <= 'M') {
                c = (char) ('Z' - (c - 'A'));
            }
            else {
                c = (char) ('A' + ('Z' - c));
            }
        }

        if (c >= 'a' && c <= 'z') {
            if (c <= 'm') {
                c = (char) ('z' - (c - 'a'));
            }
            else {
                c = (char) ('a' + ('z' - c));
            }
        }
        return c;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
