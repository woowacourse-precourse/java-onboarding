package onboarding;

public class Problem4 {
    public static String solution(String word) {

        /**
         * 괄호 안의 숫자는 아스키코드
         * A(65) -> Z(90)
         * B(66) -> Y(89)
         * C(65) -> X(88)
         * 본문자 + 변환문자 = 상수로 일정하다.
         * 즉, 변환문자 = 상수 - 본문자
         * 상수값 = 대문자일때:155, 소문자일때:219
         */

        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); // 변환될 문자

            // 알파벳 대문자 또는 소문자일때만 변환 수행
            if (Character.isUpperCase(ch)) {
                ch = (char) (155 - word.charAt(i));
            } else if (Character.isLowerCase(ch)) {
                ch = (char) (219 - word.charAt(i));
            }
            answer += ch;
        }
        return answer;
    }
}
