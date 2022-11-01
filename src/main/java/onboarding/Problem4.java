package onboarding;

public class Problem4 {
    private static String answer;
    // Uppercase 일때 Convert
    public static void convUpper(char c)
    {
        answer+=(char) ('A' + 'Z' -c);
    }
    // Lowercase 일때 Convert.
    public static void convLower(char c)
    {
        answer +=(char) ('a'+'z' - c);
    }
    // Uppercase 인지 확인.
    public static boolean checkUpper (char c)
    {
        return c>= 'A' && c<='Z';
    }
    // Lowercase 인지 확인.
    public static boolean checkLower (char c)
    {
        return c>= 'a' && c<='z';
    }

    public static String solution(String word) {
        answer= "";
        for (int i = 0 ; i< word.length(); i++)
        {
            if (checkUpper(word.charAt(i)))
                convUpper(word.charAt(i));
            else if (checkLower(word.charAt(i)))
                convLower(word.charAt(i));
            else
                answer+=word.charAt(i);
        }
        return answer;
    }
}
