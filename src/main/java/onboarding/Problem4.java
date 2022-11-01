package onboarding;

public class Problem4 {

    private static final String CHANGE_SMALL = "zyxwvutsrqponmlkjihgfedcba";
    private static final String CHANGE_LARGE = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    private static boolean isSmallAlpha(char c)
    {
        return 'a' <= c && c <= 'z';
    }

    private static boolean isLargeAlpha(char c)
    {
        return 'A' <= c && c <= 'Z';
    }

    private static boolean checkParam(String s)
    {
        int length;

        if (s == null)
            return true;
        length = s.length();
        if (length == 0 || 1000 < length)
            return true;
        return false;
    }

    private static char changeWord(char c)
    {
        if (isSmallAlpha(c))
            return CHANGE_SMALL.charAt(c - 'a');
        else if (isLargeAlpha(c))
            return CHANGE_LARGE.charAt(c - 'A');
        else
            return c;
    }

    public static String solution(String word) {
        String answer = "";
        if (checkParam(word))
            return "";
        for (int i=0; i<word.length(); i++)
            answer += changeWord(word.charAt(i));
        return answer;
    }
}
