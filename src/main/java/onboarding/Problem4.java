package onboarding;

public class Problem4 {
    public static char ReverseStr(char alpa)
    {
        char result;
        String salpa = "zyxwvutsrqponmlkjihgfedcba";
        String balpa = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        if (alpa >= 'a' && alpa <= 'z')
        {
            result = salpa.charAt(alpa - 'a');
        }
        else
        {
            result = balpa.charAt(alpa - 'A');
        }
        return result;
    }
    public static String solution(String word) {
        String answer;
        StringBuilder Mystr = new StringBuilder(word);
        for (int i = 0; i < Mystr.length(); i++)
        {
            if ((Mystr.charAt(i) >= 'a' && Mystr.charAt(i) <= 'z') ||
                    (Mystr.charAt(i) >= 'A' && Mystr.charAt(i) <= 'Z'))
            {
                Mystr.setCharAt(i, ReverseStr(Mystr.charAt(i)));
            }
        }
        word = Mystr.toString();
        answer = word;
        return answer;
    }
}
