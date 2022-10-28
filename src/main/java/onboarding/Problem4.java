package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean isAlphabet(char c) {
        if (c >= 65 && c <= 90) {
            return true;
        }
        if (c >= 97 && c <= 122) {
            return true;
        }
        return false;
    }

    public static char changeUpperWithFrogDict(char c) {
        if (c >= 'A' && c <= 'M') {
            c += 25 - ((c - 65) * 2);
            return c;
        }
        if (c >= 'N' && c <= 'Z') {
            c -= ((c - 78) * 2) + 1;
            return c;
        }
        return c;
    }
}
