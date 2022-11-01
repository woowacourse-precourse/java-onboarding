package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. word길이 체크
 * 2. 제한 사항 중 "알파벳 외의 문자는 반환하지 않는다. -> 알파벳이 아닌 정보가 들어오면 그대로 출력
 *    => 아스키 코드 값으로 범위 확인
 * 3. String => split => char => ascii(int) => 대소문자 범위 확인 => 변환 => char => String
 * 4. 핵심 로직 : asciiWord + (ASCII_Z_TO_A - ((asciiWord - A_UPPER_CASE_ASCII) * 2))
 */
public class Problem4 {
    private static final int A_UPPER_CASE_ASCII = 65;
    private static final int A_LOWER_CASE_ASCII = 97;
    private static final int Z_UPPER_CASE_ASCII = 90;
    private static final int Z_LOWER_CASE_ASCII = 122;
    private static final int ASCII_Z_TO_A = 25;
    public static String solution(final String word) {
        checkValidRange(word.length());
        String answer = "";
        answer = changeWordToAscii(word);

        return answer;
    }

    private static String changeWordToAscii(String word) {
        String answer;
        List<Integer> asciiWord = turnWordIntoAscii(word.split(""));

        List<Integer> changedAsciiWord = new ArrayList<>();
        for (int ascii : asciiWord) {
            changedAsciiWord.add(changeWordReferToGreenFrogDic(ascii));
        }
        answer = turnAsciiIntoWord(changedAsciiWord);
        return answer;
    }

    public static void checkValidRange(final int wordLength) {
        if (wordLength < 1 || wordLength > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> turnWordIntoAscii(final String[] words) {
        List<Integer> asciiWord = new ArrayList<>();
        for (String word : words) {
            asciiWord.add((int)word.charAt(0));
        }
        return asciiWord;
    }

    public static String turnAsciiIntoWord(final List<Integer> asciiList) {
        String result = "";
        for (int i : asciiList) {
            result += Character.toString((char)i);
        }
        return result;
    }

    public static int changeWordReferToGreenFrogDic(final int asciiWord){
        if (asciiWord >= A_LOWER_CASE_ASCII && asciiWord <= Z_LOWER_CASE_ASCII) {
            return asciiWord + (ASCII_Z_TO_A - ((asciiWord - A_LOWER_CASE_ASCII) * 2));
        }
        if (asciiWord >= A_UPPER_CASE_ASCII && asciiWord <= Z_UPPER_CASE_ASCII) {
            return asciiWord + (ASCII_Z_TO_A - ((asciiWord - A_UPPER_CASE_ASCII) * 2));
        }
        return asciiWord;

    }

}
