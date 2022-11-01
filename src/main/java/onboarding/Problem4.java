package onboarding;
/*
A->Z
B->Y
알파벳 변환 : 'A' + 'Z' - '현재 알파벳'
 */
public class Problem4 {
    public static String solution(String word) {
        String str = word;
        String answer = "";
        int strLen = str.length();
        for (int i = 0; i < strLen; ++i) {
            char c = str.charAt(i);
            answer += transformAlpha(c);
        }
        return answer;
    }
    private static char transformAlpha(char c)
    {
        if (c >= 'A' && c <= 'Z')
            return (char)('A' + 'Z' - c);
        else if (c >= 'a' && c <= 'z')
            return (char)('a' + 'z' - c);
        else
            return c;
    }
}
