package onboarding;

public class Problem4 {

    /**
     * 입력받은 알파벳의 reverse를 리턴한다.
     * @param input
     * @return
     */
    private static char reverseAlphabet(char input) {
        // 소문자인 경우
        if ('a' <= input && input <= 'z') {
            return (char) (input - 'z' + 'a');
        }
        // 대문자인 경우
        if ('A' <= input && input <= 'Z') {
            return (char) (input - 'Z' + 'A');
        }
        // 공백인 경우
        return input;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
