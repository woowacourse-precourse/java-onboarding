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
            return (char) ('z' - input + 'a');
        }
        // 대문자인 경우
        if ('A' <= input && input <= 'Z') {
            return (char) ('Z' - input + 'A');
        }
        // 공백인 경우
        return input;
    }

    /**
     * 입력받은 문자열을 반대로 변환하여 리턴한다.
     * @param input
     * @return
     */
    private static String buildReverseWord(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(reverseAlphabet(input.charAt(i)));
        }
        return sb.toString();
    }

    public static String solution(String word) {
        // 문자열을 반대로 변환하여 리턴
        return buildReverseWord(word);
    }
}
