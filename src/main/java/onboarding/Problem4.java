package onboarding;

public class Problem4 {
    // 대문자 65~90
    // 소문자 97~122
    // 공백문자 32

    public static char changeUpper(char c) {
        // 공백문자인 경우
        if ((int)c == 32)
            return c;

        c = (char)(65 + 90 - (int)c);
        return c;
    }

    public static char changeLower(char c) {
        c = (char)(97 + 122 - (int)c);
        return c;
    }

    public static String solution(String word) {
        String answer = "";
        char c;
        for (int i = 0;  i < word.length(); i++) {
            c = word.charAt(i);
            // 대문자 인경우
            if ((int)c < 91) {
                c = changeUpper(c);
                answer += c;
            }
            if ((int)c > 91) {
                c = changeLower(c);
                answer += c;
            }
        }

        return answer;
    }
}
