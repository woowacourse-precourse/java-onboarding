package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";


        return answer;
    }

    //알파벳 저장
    public static char[] createAlphaArray(String isAlpha)
    {
        int alphabetCount  = 26;
        char[] alphaArray = new char[alphabetCount];

        for (int i = 0; i < alphaArray.length; i++)
        {
            if (isAlpha.equals("Upper"))
                alphaArray[i] = (char)('A' + i);
            else if (isAlpha.equals("Lower"))
                alphaArray[i] = (char)('a' + i);
        }
        return alphaArray;
    }
    //알파벳을 반대로 변경
    public static String reverseAlpha(char alpha)
    {
        //대문자일 경우
        if (Character.isUpperCase(alpha))
            alpha
    }
}
