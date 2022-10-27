package onboarding;

/** TODO
 * 1. 문자별로 알파벳인지 확인
 * 2. answer 추가
 *  2-1. 알파벳일 경우 규칙에 맞게 변경
 *  2-2. 알파벳이 아닐경우 그대로
 * 3. 뒤집는 방법은 ascii코드 사용
 *  3-1. 소문자는 97~122
 *  3-2. 대문자는 65~90
 *  3-3. 해당 끝값들의 합에서 자신 아스키코드 빼서 나온 반대편 코드 값으로 문자 변경
 *      - ex) A -> Z 65+90 - 65 = 90
 *      - ex) Z -> A 65+90 - 90 - 65
 *      - 알파벳 26개로 짝이 맞기때문에 가능
 */
public class Problem4 {
    private static final int LARGE_CHAR = 65 + 90;
    private static final int SMALL_CHAR = 97 + 122;

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (isAlpha(currentChar)) {
                currentChar = changeAlpha(currentChar);
            }
            answer += currentChar;
        }
        return answer;
    }

    private static boolean isAlpha(char currentChar) {
        return ('a' <= currentChar && currentChar <= 'z') || ('A' <= currentChar && currentChar <= 'Z');
    }

    private static char changeAlpha(char ascii) {
        if (ascii <= 90) {
            return (char) (LARGE_CHAR - ascii);
        }
        return (char) (SMALL_CHAR - ascii);
    }
}
