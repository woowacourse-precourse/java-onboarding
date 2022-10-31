package onboarding;

import java.util.*;

public class Problem4 {
    private static Map<String, String> alphabetTable;

    public static String solution(String word) {
        initialize();
        checkWordCollect(word);

        return reverseWord(word);
    }

    /**
     * 글자 검증
     * @param word 문자열
     */
    private static void checkWordCollect(String word) {
        int lengthWord = word.length();
        if (lengthWord == 0 || lengthWord > 1_000) {
            throw new RuntimeException("변환 가능한 범위를 초과했습니다. 문자 크기는 1 ~ 1000 사이여야 합니다.");
        }
    }

    /**
     * 알파벳 변환
     * @param word 변환할 문자열
     * @return 변환된 문자열
     */
    private static String reverseWord(String word) {
        String[] oneLetterWords = getOneLetterWords(word);
        List<String> newWord = new LinkedList<>();

        for (String oneLetterWord: oneLetterWords) {
            String newOneLetterWord = getReverseAlphabet(oneLetterWord);

            if (isUpperCase(oneLetterWord)) {
                newOneLetterWord = newOneLetterWord.toUpperCase();
            }

            newWord.add(newOneLetterWord);
        }

        return String.join("", newWord);
    }

    /**
     * 알파벳 나열 및 할당
     * @return 생성된 알파벳 테이블
     */
    private static Map<String, String> createAlphabetTable() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] oneLetterWords = getOneLetterWords(alphabet);
        int lengthOneLetterWords = oneLetterWords.length;
        Map<String, String> alphabetTable = new HashMap<>();

        for (int i = 0; i < lengthOneLetterWords; i++) {
            alphabetTable.put(oneLetterWords[i], oneLetterWords[lengthOneLetterWords - (i + 1)]);
        }

        return alphabetTable;
    }

    /**
     * 대응되는 글자를 반환
     * @param oneLetterWord 한글자씩 분할된 글자
     * @return 알파벳 테이블에 대응되는 글자 반환
     */
    private static String getReverseAlphabet(String oneLetterWord) {
        return alphabetTable.getOrDefault(oneLetterWord.toLowerCase(), oneLetterWord);
    }

    /**
     * 문자를 한글자씩 분할
     * @param word 분할할 글자
     * @return 분할된 글자
     */
    private static String[] getOneLetterWords(String word) {
        return word.split("");
    }

    /**
     * 글자가 알파벳 대문자인지 확인
     * @param word 글자
     * @return 대문자 여부
     */
    private static boolean isUpperCase(String word) {
        return word.toUpperCase().equals(word);
    }

    /**
     * 초기화
     */
    private static void initialize() {
        alphabetTable = createAlphabetTable();
    }
}
