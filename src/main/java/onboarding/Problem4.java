package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char change(char c) {
        if (Character.isUpperCase(c)) {
            return changeUpperWithFrogDict(c);
        }
        if (Character.isLowerCase(c)) {
            return changeLowerWithFrogDict(c);
        }
        return c;
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

    public static char changeLowerWithFrogDict(char c) {
        if (c >= 'a' && c <= 'm') {
            c += 25 - ((c - 97) * 2);
            return c;
        }
        if (c >= 'n' && c <= 'z') {
            c -= ((c - 110) * 2) + 1;
            return c;
        }
        return c;
    }
}
