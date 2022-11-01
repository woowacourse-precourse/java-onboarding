package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char getSymmetricChar(char c) {
        int charIndex = 0;
        if(c >= 'A' & c <= 'Z'){
            charIndex = c - 'A';
            return (char) ('A' + 25 - charIndex);
        } else if(c >= 'a' && c <= 'z'){
            charIndex = c - 'a';
            return (char) ('a' + 25 - charIndex);
        } else {
            return c;
        }
    }
}
