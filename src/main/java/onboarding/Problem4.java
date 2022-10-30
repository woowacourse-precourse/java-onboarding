package onboarding;

public class Problem4 {

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
        int length = s.length();

        if (length == 0 || 1000 < length)
            return true;
        return false;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
