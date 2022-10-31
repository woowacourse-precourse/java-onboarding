package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char convert(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            char alphabet = (char) (ch - 'A');
            return (char) ('Z' - alphabet);
        } else if (ch >= 'a' && ch <= 'z') {
            char alphabet = (char) (ch - 'a');
            return (char) ('z' - alphabet);
        }
        return ch;
    }

}
