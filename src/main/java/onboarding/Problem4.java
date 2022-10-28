package onboarding;

public class Problem4 {
    public static final int BIG = 0;
    public static final int SMALL = 1;
    public static final int NONE = -1;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char convert(char c) {
        if (isAlphabet(c) == BIG)
            return (char) ('A' + 'Z' - c);
        return (char) ('a' + 'z' - c);
    }

    public static int isAlphabet(char c) {
        if ('A' <= c && c <= 'Z')
            return BIG;
        if ('a' <= c && c <= 'z')
            return SMALL;
        return NONE;
    }
}
