package onboarding;

import java.util.*;

public class Problem4 {
    private static Map<String, String> alphabetTable;

    public static String solution(String word) {
        initialize();

        if (!validateWord(word)) {
            return "";
        }

        return changeWord(word);
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
     * 알파벳 변환
     * @param word 변환할 문자열
     * @return 변환된 문자열
     */
    private static String changeWord(String word) {
        String[] splitWord = getOneLetterWords(word);
        LinkedList<String> newWord = new LinkedList<>();

        // 알파벳 대소문자를 유지하면서 변환
        for (String character: splitWord) {
            String lowerCharacter = character.toLowerCase();
            String newCharacter = alphabetTable.getOrDefault(lowerCharacter, character);

            // 알파벳 소문자인지 체크
            if (!lowerCharacter.equals(character)) {
                newCharacter = newCharacter.toUpperCase();
            }

            newWord.add(newCharacter);
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
        Map<String, String> table = new HashMap<>();

        for (int i = 0; i < lengthOneLetterWords; i++) {
            table.put(oneLetterWords[i], oneLetterWords[lengthOneLetterWords - (i + 1)]);
        }

        return table;
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
     * 초기화
     */
    private static void initialize() {
        alphabetTable = createAlphabetTable();
    }
}
