package onboarding;

import onboarding.exception.InputRangeException;

public class Problem4 {
    static final char START_ASCII_BY_UPPER_CASE = 'A';
    static final char END_ASCII_BY_UPPER_CASE = 'Z';
    static final char START_ASCII_BY_LOWER_CASE = 'a';
    static final char END_ASCII_BY_LOWER_CASE = 'z';

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder("");

        // 입력 문자열에 대한 검증 작업을 진행한다.
        if(isNotStrLengthRange(word)) {
            throw new InputRangeException("word의 길이는 1~1000 사이여야 합니다.");
        }

        // 입력 문자열을 배열로 변환한다.
        char[] wordArr = getCharArr(word);

        for(Character wordVal : wordArr) {
            // 만약 알파벳이 아니라면 그대로 붙인다.
            if(isNotAlphabetic(wordVal)) {
                answer.append(wordVal);
                continue;
            }

            // 알파벳이라면 변환 작업을 진행한다.
            char reversedVal = changeReversed(wordVal);
            answer.append(reversedVal);
        }

        return answer.toString();
    }

    /**
     * 입력 문자열에 대한 검증을 진행한다.
     *
     * @param word 입력 문자열
     */
    private static boolean isNotStrLengthRange(String word) {
        return word.length() < 1 || word.length() > 1000;
    }

    /**
     * 청개구리 사전에 따라 단어를 변환한다.
     *
     * @param value 원본 단어 요소
     * @return char - 사전에 따라 변환된 요소를 리턴한다. 대문자는 대문자로, 소문자는 소문자로 리턴된다.
     */

    private static char changeReversed(char value) {
        if (Character.isUpperCase(value))
            return (char) (END_ASCII_BY_UPPER_CASE - (value - START_ASCII_BY_UPPER_CASE));
        return (char) (END_ASCII_BY_LOWER_CASE - (value - START_ASCII_BY_LOWER_CASE));
    }

    /**
     * 요소가 알파벳이 아닌지 판단한다.
     *
     * @param value 판단할 요소
     * @return 알파벳이 아니라면 true, 맞다면 false
     */
    private static boolean isNotAlphabetic(Character value) {
        return !Character.isAlphabetic(value);
    }

    /**
     * 파라미터로 받은 문자열을 char형 배열로 분해하여 리턴한다.
     *
     * @param str 문자열
     * @return char[] - 입력으로 받은 문자열에 대해 char형 배열로 쪼갠 결과를 리턴한다.
     */
    private static char[] getCharArr(String str) {
        return str.toCharArray();
    }
}
