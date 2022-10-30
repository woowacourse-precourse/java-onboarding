package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] characters = word.split("");
        for (int i = 0; i < characters.length; i++) {
            if (isSpace(characters[i])) {
                continue;
            }
            characters[i] = frogConverter(characters[i]);
        }
        answer = toString(characters);
        return answer;
    }

    /**
     * 문자를 청개구리 문자로 변환
     *
     * @param str 문자
     * @return 청개구리 문자
     */
    private static String frogConverter(String str) {
        String result = "";
        int range = 'Z' - 'A';
        char character = str.charAt(0);
        if (isUpperCase(character)) {
            result = String.valueOf((char) (character + (range - ((character - 'A') * 2))));
        } else {
            result = String.valueOf((char) (character + (range - ((character - 'a') * 2))));
        }
        return result;
    }

    /**
     * 배열을 문자열로 변환
     * @param array 변환할 문자열 배열
     * @return  변환된 문자열
     */
    private static String toString(String[] array) {
        return String.join("", array);
    }

    /**
     * 대소문자 판별기
     *
     * @param c 문자
     * @return 대소문자 판별 결과
     */
    private static boolean isUpperCase(char c) {
        return c <= 'Z';
    }

    /**
     * 뛰어쓰기 인지 아닌지 판별
     *
     * @param str 문자
     * @return 뛰어쓰기의 유무
     */
    private static boolean isSpace(String str) {
        return str.equals(" ");
    }
}
