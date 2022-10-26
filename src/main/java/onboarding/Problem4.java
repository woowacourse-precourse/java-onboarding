package onboarding;

import java.util.Collections;
import java.util.HashMap;

public class Problem4 {
    private static HashMap<String, String>  alphabetTable;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /**
     * 문자열 검증
     * @param word 문자열
     * @return 검증 결과 값
     */
    private static boolean validateWord(String word) {
        int lengthWord = word.length();
        return (lengthWord > 0 && lengthWord <= 1000);
    }

    /**
     * 알파벳 나열 및 할당
     * @return 생성된 알파벳 테이블
     */
    private static HashMap<String, String> createAlphabetTable() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] splitAlphabet = splitWord(alphabet);
        int lengthSplitAlphabet = splitAlphabet.length;

        HashMap<String, String> table = new HashMap<>();

        // 알파벳를 차례로 나열
        for (int i = 0; i < lengthSplitAlphabet; i++) {
            // 나열된 알파벳에 역순으로 알파벳 할당
            table.put(splitAlphabet[i], splitAlphabet[lengthSplitAlphabet - (i + 1)]); // 배열 길이가 최대 인덱스보다 1 크다.
        }

        return table;
    }

    /**
     * 문자열 분리
     * @param word 문자열
     * @return 분리된 문자열
     */
    private static String[] splitWord(String word) {
        return word.split("");
    }
}
