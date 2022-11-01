package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            // 문자열의 각 문자에 접근 후 아스키 값으로 변환하는 기능
            char ch = word.charAt(i);
            int ascii = (int)ch;

            // 알파벳 외의 문자는 변환하지 않는다
            if (65 <= ascii && ascii <= 90) { // 문자가 대문자일 경우

            } else if (97 <= ascii && ascii <= 122) { // 문자가 소문자일 경우

            }
        }
        return answer;
    }
}
