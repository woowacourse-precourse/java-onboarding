package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            answer.append(change(word.charAt(i)));
        }

        return answer.toString();
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
