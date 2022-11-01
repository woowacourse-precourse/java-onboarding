/*
 * 우테코 1주차 프리코스 미션 - 문제 4
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM4.md]
 *
 */
package onboarding;
/**
 * checkStr : 전달받은 문자열이 제한사항과 맞는지 체크하는 메서드
 **/
public class Problem4 {

    public static String solution(String word) {
        /* 제한 사항 처리 */
        if (checkStr(word) == null) {
            return "문자열 word가 제한 사항을 위반했습니다.";
        }

        String answer = "";
        String upper = "ABCDEFGHIJKLMNOPQURTUVWXYZ";
        String upperReverse = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String lowerReverse = "zyxwvutsrqponmlkjihgfedcba";

        /* word 각 문자 확인 */
        for (int i = 0; i < word.length();i++) {

            /* upper 문자열의 각 문자와, 소문자/대문자 비교 */
            for (int j = 0; j < upper.length(); j++) {
                if (Character.isLowerCase(word.charAt(i))) {            // 소문자일경우
                    if (word.substring(i, i + 1).equals(lower.substring(j, j + 1))) {
                        answer += lowerReverse.substring(j, j + 1);
                    }
                }else if (Character.isUpperCase(word.charAt(i))) {     // 대문자일경우
                    if (word.substring(i, i + 1).equals(upper.substring(j, j + 1))) {
                        answer += upperReverse.substring(j, j + 1);
                    }
                } else if (word.substring(i, i + 1).equals(" ")) {      // 공백일경우
                    answer += " ";
                    break;
                }
            }
        }

        return answer;
    }

    private static String checkStr(String word) {
        /* 문자열 길이가 1이상 1000이하인지 확인 */
        if (word.length() < 1 && word.length() > 1000) {
            return null;
        }
        return word;
    }
}
