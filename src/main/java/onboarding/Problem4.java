package onboarding;

트import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. word길이 체크
 * 2. 제한 사항 중 "알파벳 외의 문자는 반환하지 않는다. -> 알파벳이 아닌 정보가 들어오면 그대로 출력
 *    => 아스키 코드 값으로 범위 확인
 * 3. String => split => char => ascii(int) => 대소문자 범위 확인 => 변환 => char => String
 * 4. 아스키 코드 a 와 z 의 범위가 25임 b랑 y 랑 차이는 23 c-x = 21 이런식으로 2개씩 줄어드니가 이거 고려해서 계산
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

        String[] splitWord = word.split("");




        return answer;
    }
    public static void checkValidRange(final int wordLength) {
        if (wordLength < 1 || wordLength > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> turnWordIntoAscii(String[] words) {
        List<Integer> asciiWord = new ArrayList<>();
        for (String word : words) {
            asciiWord.add((int)word.charAt(0));
        }
        return asciiWord;
    }
}
