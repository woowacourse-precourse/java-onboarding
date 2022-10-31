package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char c : word.toCharArray()) {
            if (c == 32) {
                answer += ' ';
                continue;
            }

            if (65 <= c && c <= 90) {
                answer += (char)(90 - (c - 65));
            }else if (97 <= c && c <= 122) {
                answer += (char)(122 - (c - 97));
            }else {
                // 알파벳 값이 아닐경우 예외처리
                return "-1";
            }
        }

        return answer;
    }
}
