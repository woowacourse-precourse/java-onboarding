/*
 * Problem4.java
 *
 * 2022-10-29
 *
 */
package onboarding;

/**
 * 우아한 테크코스 - 프리코스 1주차 청개구리 문자열변환
 *
 * @author 이준현
 * @version 1.00 2022년 10월 29일
 */
public class Problem4 {

    /**
     * 모든 문자열에 대하여 변환을 완료하고 완성된 문자열을 반환
     *
     * @param str 변환시킬 문자열 원본값
     * @return 청개구리 형식에 의해 변환된 문자열
     */
    private static String textDecoding(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            c = getConvertCharacter(c);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * 아스키코드를 사용하여 문제의 형식으로 문자변환
     *
     * @param c 전체 string중 1개의 문자
     * @return 변환된 문자
     */
    private static char getConvertCharacter(char c) {
        int valueDifference;
        if (isAlpha(c)) {
            if (Character.isUpperCase(c)) {
                valueDifference = 'Z' - c + 'A';
            } else {
                valueDifference = 'z' - c + 'a';
            }
            c = (char) valueDifference;
        }
        return c;
    }

    /**
     * 입력받은 문자가 알파벳인지 여부판단
     *
     * @param c 알파벳에 부합한지 판단할 문자
     * @return 알파벳일 시 true, 다른 문자일시 false
     */
    private static boolean isAlpha(char c) {
        return (int) c >= 65 && (int) c <= 122;
    }

    /**
     * 문자열을 입력받고 문제의 형식에 맞춰 변환
     *
     * @param word 변화시킬 문자열
     * @return 변화가 완료된 문자열
     */
    public static String solution(String word) {
        String answer = "";
        answer = textDecoding(word);
        return answer;
    }
}
