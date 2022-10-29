package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        answer = reverseString(word, answer);
        return answer;
    }

    private static String reverseString(String word, String answer) {
        for (int i = 0; i < word.length(); i++) {
            char reverse = word.charAt(i);
            if (reverse >= 'A' && reverse <= 'Z') {
                answer += (char) (('Z' - reverse) + 'A'); // 대문자 청개구리 사전 참고하여 ASCII 코드 활용
            } else if (reverse >= 'a' && reverse <= 'z') {
                answer += (char) (('z' - reverse) + 'a'); // 소문자 청개구리 사전 참고하여 ASCII 코드 활용
            } else {
                answer += reverse; // 알파벳이 아닌 경우에는 그대로 넣기.
            }

        }
        return answer;
    }
}
