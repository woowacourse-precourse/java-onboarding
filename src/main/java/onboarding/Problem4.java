package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 대문자
            if (Character.isUpperCase(c)) {
                c = (char) ('Z' - (c - 'A'));
            }

            // 소문자
            if (Character.isLowerCase(c)) {
                c = (char) ('z' - (c - 'a'));
            }

            // 문자 더하기
            answer += c;
        }
        return answer;
    }
}
