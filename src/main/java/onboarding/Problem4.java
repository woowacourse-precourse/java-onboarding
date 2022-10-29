package onboarding;

public class Problem4 {
    private static final int UPPER_CASE = 155;
    private static final int LOWER_CASE = 219;

    public static String solution(String word) {
        /* [요구] 청개구리 사전을 참고해 문자열을 반대로 변환하기 */
        return reverseString(word);
    }

    public static String reverseString(String word) {
        String reversedWord = "";
        for (char character : word.toCharArray()) {

            if ('A' <= character && character <= 'Z') {
                reversedWord += reverseUpperCase(character);
                continue;
            }

            if ('a' <= character && character <= 'z') {
                reversedWord += reverseLowerCase(character);
                continue;
            }

            // 알파벳 외의 문자는 변환하지 않는다.
            reversedWord += character;
        }

        return reversedWord;
    }

    // 대문자를 반대로 변환하는 메서드
    public static String reverseUpperCase(char character) {
        int asciiVal = UPPER_CASE - (int) character;
        return Character.toString((char) asciiVal);
    }

    // 소문자를 반대로 변환하는 메서드
    public static String reverseLowerCase(char character) {
        int asciiVal = LOWER_CASE - (int) character;
        return Character.toString((char) asciiVal);
    }
}
