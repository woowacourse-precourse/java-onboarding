package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 대소문자 상관없이 몇 번째 알파벳인지 반환
    private static int getVector(char ch) {
        if ('a' <= ch && ch <= 'z')
            return ch - 'a';
        else if ('A' <= ch && ch <= 'Z')
            return ch - 'A';
        return -1;   // 알파벳이 아님
    }
}
