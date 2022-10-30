package onboarding;

public class Problem2 {

    private static boolean IsSmallAlpha(char c)
    {
        return 'a' <= c && c <= 'z';
    }

    private static boolean checkParam(String s)
    {
        if (s == null)
            return true;
        for (int i=0; i<s.length(); i++)
            if (!IsSmallAlpha(s.charAt(i)))
                return true;
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
