package onboarding;

/**
 * 중복 문자 제거 문제
 *
 * 문제 설명 :
 *  암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다.
 *  예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
 *
 *  "browoanoommnaon"
 *  "browoannaon"
 *  "browoaaon"
 *  "browoon"
 *  "brown"
 *
 *  임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 * - cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
 * - cryptogram은 알파벳 소문자로만 이루어져 있다.
 *
 *  @author     scyllacore
 *  @version    1.1 2022/10/31
 */

public class Problem2 {
    /*
     * 구현 사항
     * 1. isDuplicates : 중복 확인.
     * 2. removeDuplicates : 문자열의 중복을 모두 제거.
     * 3. solution : 최종적으로 중복이 제거된 문자열 반환.
     */

    /**
     * 1. 문자열에 중복이 존재하는지 확인
     *
     * @param str 중복이 존재하는지 검사할 문자열.
     * @return 문자열에서 중복이 시작되는 지점 반환. 중복이 없을 시 -1 반환.
     */
    static int isDuplicates(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return i;
        }

        return -1;      // 0을 idx번호로 사용할 수 있기 때문에 -1로 반환한다.
    }

    /**
     * 2. 문자열에 존재하는 중복이 없어질 때까지 문자열을 검사하고, 중복을 지우는 과정을 반복.
     *
     * @param cryptogram 원본 문자열.
     * @return 모든 중복이 제거된 문자열.
     */
    static String removeDuplicates(String cryptogram) {

        String newCryptogram = cryptogram;

        for (; ; ) {

            int start = isDuplicates(newCryptogram);

            if (start == -1) {
                return newCryptogram;
            }

            int end = start + 1;

            for (; end < newCryptogram.length(); end++) {
                if (newCryptogram.charAt(start) != newCryptogram.charAt(end)) break;
            }
            newCryptogram = newCryptogram.substring(0, start) + newCryptogram.substring(end);
        }


    }

    /**
     * 3. 최종적으로 중복이 모두 제거된 문자열을 반환.
     *
     * @param cryptogram 원본 문자열.
     * @return 모든 중복이 제거된 최종 문자열.
     */
    public static String solution(String cryptogram) {
        String answer = removeDuplicates(cryptogram);
        return answer;
    }
}
