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
        validateWord(word);
        DictionaryTable table = new DictionaryTable();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ++i) {
            sb.append(table.get(word.charAt(i)));
        }
        return sb.toString();
    }

    private static void validateWord(String word) {
        if (1 <= word.length() && word.length() <= 1000) {
            return;
        }
        throw new RuntimeException("word는 1자 이상 1000자 이하만 가능합니다");
    }

    static class DictionaryTable {

        Map<Character, Character> dict = new HashMap<>();

        public DictionaryTable() {
            for (int i = 0; i <= 'Z' - 'A'; ++i) {
                dict.put((char) ('A' + i), (char) ('Z' - i));
                dict.put((char) ('a' + i), (char) ('z' - i));
            }
            dict.put(' ', ' ');
        }

        public char get(char ch) {
            return dict.get(ch);
        }
    }
}
