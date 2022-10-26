package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";


        return answer;
    }
    
    //알파벳을 반대로 변경
    public static char reverseAlpha(char alpha)
    {
        int minus = 0;
        char result;

        //대문자일 경우
        if (Character.isUpperCase(alpha))
            minus = alpha - 'A';
        else if (Character.isLowerCase(alpha))
            minus = alpha - 'a';

        result = (char)(25 - (minus * 2));
        return result;
    }
}
