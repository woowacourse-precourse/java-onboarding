package onboarding;

public class Problem4 {
    private static int UPPER_SUM = 'A' + 'Z';
    private static int LOWER_SUM = 'a' + 'z';
    public static String solution(String word) {
        String answer = "";
        answer = translate(word);

        return answer;
    }

    /** 청개구리의 규칙이 적용된 문자열을 반환합니다. */
    private static String translate(String word) {
        char[] charArr;
        charArr = word.toCharArray();
        for (int i=0;i<word.length();i++)
            charArr[i] = calculate(charArr[i]);

        return String.valueOf(charArr);
    }

    /** 하나의 문자에 대해 청개구리 규칙을 적용하여 반환합니다. */
    private static char calculate(char chr) {
        if (('A' < chr) && ('Z' > chr))
            return (char)(UPPER_SUM - chr);
        else if (('a' < chr) && ('z' > chr))
            return (char)(LOWER_SUM - chr);
        else
            return chr;
    }
}
