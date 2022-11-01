package onboarding;
/*
while (1)
{
    1. 연속되는 같은 문자가 없다면, 종료
    2. 중복되는 문자열전까지, 중복되는 다음 문자열부터 문자열 끝까지 이어붙이기
}
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String str = cryptogram;
        while (true) {
            if (!isDuplicateStr(str))
                break;
            str = removeDuplicateStr(str);
        }
        return str;
    }
    private static boolean isDuplicateStr(String str)
    {
        int str_len = str.length();
        for (int i = 1; i < str_len; ++i) {
            char before = str.charAt(i - 1);
            if (before == str.charAt(i))
                return true;
        }
        return false;
    }
    private static String removeDuplicateStr(String str) {
        String newStr = "";
        int str_len = str.length();
        for (int i = 1; i < str_len; ++i) {
            char before = str.charAt(i - 1);
            if (before == str.charAt(i))
                newStr = str.substring(0, i - 1) + str.substring(i + 1, str_len);
        }
        return newStr;
    }
}
