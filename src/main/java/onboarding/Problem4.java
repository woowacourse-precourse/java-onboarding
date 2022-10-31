package onboarding;

/* 기능 목록
 * 알파벳을 반대로 변환해 주는 기능
 * 문자열을 반복하는 기능
 * */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder reversed = new StringBuilder();

        for (char letter : word.toCharArray()) {
            reversed.append(reverse(letter));
        }
        answer = reversed.toString();

        return answer;
    }

    /**
     * 문자를 변환하여 반환한다.
     *
     * @param letter 변환할 문자
     * @return 알파벳을 변환하여 반환, 알파벳이 아닐 경우 변환하지 않고 반환
     */
    static char reverse(char letter) {
        char res;

        if ('A' <= letter && letter <= 'Z') {
            res = (char) ('Z' - letter + 'A');
        } else if ('a' <= letter && letter <= 'z') {
            res = (char) ('z' - letter + 'a');
        } else {
            res = letter;
        }

        return res;
    }
}
