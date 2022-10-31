/*
 * 우테코 1주차 프리코스 미션 - 문제 2
 * [https://github.com/gilyeon00/java-onboarding/blob/main/docs/PROBLEM2.md]
 *
 * */
package onboarding;
/**
 * checkStr : 전달받은 문자열이 제한사항과 맞는지 체크하는 메서드
 **/

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        if (checkStr(cryptogram) == null) {
            return "문자열 cryptogram이 제한 사항을 위반했습니다.";
        }

        return answer;
    }

    private static String checkStr(String cryptogram) {
        if (cryptogram.length() < 1 && cryptogram.length() > 1000) {
            return null;
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isLowerCase(cryptogram.charAt(i)) != true) {
                return null;
            }
        }

        return cryptogram;
    }
}
