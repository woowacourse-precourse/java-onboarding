package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = returnAlpha(word);

        return answer;
    }
    public static String returnAlpha(String word)
    {
        String reverseStr = "";
        for (int i = 0; i < word.length(); i++)
            reverseStr += reverseAlpha(word.charAt(i));

        return reverseStr;
    }
    //알파벳을 반대로 변경
    public static char reverseAlpha(char alpha)
    {
        int minus = 0;
        char result;

        //대문자일 경우
        if (Character.isUpperCase(alpha))
        {
            minus = alpha - 'A';
            result = (char)(alpha + 25 - (minus * 2));
        }
        else if (Character.isLowerCase(alpha))
        {
            minus = alpha - 'a';
            result = (char)(alpha + 25 - (minus * 2));
        }
        else
            result = alpha;
        return result;
    }
}
