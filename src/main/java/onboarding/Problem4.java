package onboarding;

public class Problem4 {
    private static String answer;
    public static void convUpper(char c)
    {
        answer+=(char) ('A' + 'Z' -c);
    }

    public static  void convLower(char c)
    {
        answer +=(char) ('a'+'z' - c);
    }

    public static boolean checkUpper (char c)
    {
        return c>= 'A' && c<='Z';
    }

    public static boolean checkLower (char c)
    {
        return c>= 'a' && c<='z';
    }

    public static String solution(String word) {
        answer= "";
        for (int i = 0 ; i< word.length(); i++)
        {
            if (checkUpper(word.charAt(i))) {
                convUpper(word.charAt(i));
            }
            else if (checkLower(word.charAt(i)))
            {
                convLower(word.charAt(i));
            }
            else
                answer+=word.charAt(i);
        }
        return answer;
    }
}
