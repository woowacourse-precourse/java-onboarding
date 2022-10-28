package onboarding;
/*
    기능 목록
    1. 대응하는 알파벳을 구하는 기능
    2. 알파벳인지 확인하는 기능
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer += getReverse(word.charAt(i));
        }
        return answer;
    }

    private static boolean isAlpha(char ch) {
        return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122));
    }

    private static char getReverse(char ch) {
        if (isAlpha(ch) == false)
            return ch;
        if (Character.isUpperCase(ch) == true) {
            if (ch <= 'M')
                ch += 1 + (('M' - ch) * 2);
            else
                ch -= 1 + ((ch - 'N') * 2);
        }
        else if (Character.isLowerCase(ch) == true) {
            if (ch <= 'm')
                ch += 1 + (('m' - ch) * 2);
            else
                ch -= 1 + ((ch - 'n') * 2);
        }
        return ch;
    }
}
