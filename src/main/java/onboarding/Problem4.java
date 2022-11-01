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
