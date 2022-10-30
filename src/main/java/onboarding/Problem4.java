package onboarding;
/*
    기능 목록
    1. 대응하는 알파벳을 구하는 기능 -> getReverse
        a. 대응하는 알파벳이 대문자인 경우 -> getReverseUpperCase
        b. 대응하는 알파벳이 소문자인 경우 -> getReverseLowerCase
    2. 알파벳인지 확인하는 기능 -> isAlpha
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++)
            answer.append(getReverse(word.charAt(i)));
        return answer.toString();
    }

    private static boolean isAlpha(char ch) { return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)); }

    private static char getReverse(char ch) {
        if (!isAlpha(ch))
            return ch;
        if (Character.isUpperCase(ch))
            return getReverseUpperCase(ch);
        else if (Character.isLowerCase(ch))
            return getReverseLowerCase(ch);
        return ch;
    }

    private static char getReverseUpperCase(char ch) {
        if (ch <= 'M')
            return (char) (ch + (1 + ('M' - ch) * 2));
        else
            return (char) (ch - (1 + (ch - 'N') * 2));
    }

    private static char getReverseLowerCase(char ch) {
        if (ch <= 'm')
            return (char) (ch + (1 + ('m' - ch) * 2));
        else
            return (char) (ch - (1 + (ch - 'n') * 2));
    }
}
