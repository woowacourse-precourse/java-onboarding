package onboarding;

/**
 * 🚀 기능 요구 사항
 * 암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
 *
 * "browoanoommnaon"
 * "browoannaon"
 * "browoaaon"
 * "browoon"
 * "brown"
 * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 * cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
 * cryptogram은 알파벳 소문자로만 이루어져 있다.
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder cryptogramSb = new StringBuilder(cryptogram);
        int sameCount = 1;
        int firstIdx = 0;
        for (int i = 0; i < cryptogramSb.length() - 1; i++) {
            if (sameCount == 1) {
                firstIdx = i;
            }
            char currentChar = cryptogramSb.charAt(i);
            char nextChar = cryptogramSb.charAt(i + 1);
            if (currentChar == nextChar) {
                sameCount++;
                continue;
            }
            if (sameCount > 1) {
                cryptogramSb.delete(firstIdx, firstIdx + sameCount);
                sameCount = 1;
                i = -1;
            }
        }
        if (sameCount > 1) {
            cryptogramSb.delete(firstIdx, firstIdx + sameCount);
        }
        return cryptogramSb.toString();
    }
}
