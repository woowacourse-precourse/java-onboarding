package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    //소문자 1 대문자 2 그외 -1로  문자 구분
    private static int divideChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            return 2;
        }

        return -1;
    }
}
