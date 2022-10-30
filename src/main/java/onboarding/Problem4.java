package onboarding;

public class Problem4 {
    private static final char UPPER_CASE = 'A';
    private static final char LOWER_CASE = 'a';
    private static final int ALPHABET_RANGE = 'Z' - 'A';

    public static String solution(String word) {
        String answer = "";
        String[] characters = word.split("");
        for (int i = 0; i < characters.length; i++) {
            if (hasSpace(characters[i])) {
                continue;
            }
            characters[i] = frogConverter(characters[i]);
        }
        answer = toString(characters);
        return answer;
    }

    /**
     * 문자를 청개구리 문자로 변환한다.
     *
     * @param str 문자
     * @return 청개구리 문자를 반환한다.
     */
    private static String frogConverter(String str) {
        String result = "";
        char character = str.charAt(0);
        result = String.valueOf((char) (character + (ALPHABET_RANGE - ((character - isUpperCase(character)) * 2))));
        return result;
    }

    /**
     * 배열을 문자로 변환한다.
     *
     * @param array 변환할 문자열 배열
     * @return 변환된 문자를 반환한다.
     */
    private static String toString(String[] array) {
        return String.join("", array);
    }

    /**
     * 대소문자를 판별한다.
     *
     * @param c 문자
     * @return 대소문자 판별시 ture 이면 'A'를 반환하고 false 이면 'a'를 반환한다.
     */
    private static char isUpperCase(char c) {
        if (c <= 'Z') {
            return UPPER_CASE;
        }
        return LOWER_CASE;
    }

    /**
     * 문자가 뛰어쓰기 인지 아닌지 판별한다.
     *
     * @param str 문자
     * @return 뛰어쓰기가 존재하면 ture 를 반환한다.
     */
    private static boolean hasSpace(String str) {
        return str.equals(" ");
    }
}
