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
        /* 제한 사항 처리 */
        if (checkStr(cryptogram) == null) {
            return "문자열 cryptogram이 제한 사항을 위반했습니다.";
        }

        String answer = "answer";
        String tmp = answer;
        String subString = "";
        boolean isComplete = false;

        while (isComplete != true) {
            tmp = answer;

            if (cryptogram.length() == 2 && cryptogram.charAt(0) == cryptogram.charAt(1)) {
                answer = "";        // 문자열이 2글자, 중복 문자로 구성되어있을때 (ex. bb)
                break;
            } else {    // 앞뒤 문자가 같은 지 확인 -> 같다면 substring에 넣어주기
                for (int i = 1; i < cryptogram.length() - 1; i++) {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i + 1) || cryptogram.charAt(i) == cryptogram.charAt(i - 1))
                        subString += cryptogram.charAt(i);
                }
            }

            /* 중복문자에 해당하는 substring은 없애주기 (null로 replace)*/
            answer = cryptogram.replaceAll(subString, "");
            cryptogram = answer;

            /* 이전과 바뀐 값이 없다면(중복 문자가 없다면) */
            if (tmp.equals(answer)) {
                isComplete = true;
            }

            /* 다음 번 중복문자를 담기위해, subString값 초기화 */
            subString = "";
        }

        return answer;
    }

    private static String checkStr(String cryptogram) {
        /* 문자열 길이가 1이상 1000이하인지 확인 */
        if (cryptogram.length() < 1 && cryptogram.length() > 1000) {
            return null;
        }

        /* 문자열이 소문자로 이뤄졌는지 확인 */
        for (int i = 0; i < cryptogram.length(); i++) {
            if (Character.isLowerCase(cryptogram.charAt(i)) != true) {
                return null;
            }
        }

        return cryptogram;
    }
}
