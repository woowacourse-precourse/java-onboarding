package onboarding;

import java.util.HashMap;
import java.util.Map;

/**
 * > 요구사항
 *  1. 주어진 매핑 값을 Hash 테이블에 모두 저장한다
 *  2. StringBuilder를 활용해 출력한다.
 */
public class Problem4 {

    public static String solution(String word) {
        Map<Character, Character> dict = new HashMap<>();
        for (int i = 0; i <= 'Z' - 'A'; ++i) {
            dict.put((char) ('A' + i), (char) ('Z' - i));
            dict.put((char) ('a' + i), (char) ('z' - i));
        }
        dict.put(' ', ' ');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            sb.append(dict.get(word.charAt(i)));
        }
        return sb.toString();
    }
}
