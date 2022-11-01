package onboarding;

public class Problem4 {
    /*
        기능 요구 사항 목록
        1. 각 알파벳 아스키의 반대되는 아스키를 반환하는 함수
        2. 단어에 반대되는 문자열 반환하는 함수
        3. solution 함수
    */

    // 반대 아스키 반환 함수
    private static int reverseAscii(int ascii) {
        // 대문자 알파벳의 반대 아스키 반환
        if (ascii >= 65 && ascii <= 90)
            return 155 - ascii;

        // 소문자 알파벳의 반대 아스키 반환
        if (ascii >= 97 && ascii <= 122)
            return 219 - ascii;

        // 그 외의 문자는 그대로 반환
        return ascii;
    }

    // 반대 단어 반환 함수
    private static String reverseWord(String word) {
        String reversed = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int reverse = reverseAscii(letter);
            char reverseChar = (char) reverse;
            reversed += reverseChar;
        }
        return reversed;
    }

    public static String solution(String word) {
        return reverseWord(word);
    }
}
