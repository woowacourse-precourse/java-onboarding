package onboarding;

public class Problem4 {
    public static char getEncodedChar(char c) {
        if ('a' <= c && c <= 'z') {
            return (char) ('a' + 'z' - c);
        } else if ('A' <= c && c <= 'Z') {
            return (char) ('A' + 'Z' - c);
        } else {
            return c;
        }
    }

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            answer += getEncodedChar(word.charAt(i));
        }
        System.out.println(answer);

        return answer;
    }
}
