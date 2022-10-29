package onboarding;

/**
 * 큰 틀의 기능
 * - 아스키 코드 개념
 * 1. 소문자 대문자 문자 판별 함수
 * 2. 소문자 알파벳 변환기능
 * 3. 대문자 알파벳 변환기능
 * 4. 알파벳 합치는 기능
 * 5. 전체 기능을 실핼 시켜주는 기능
 */

/**
 * 1. 소문자 대문자 문자 판별 함수
 */


public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {

    }

    private static String distinguishInput(char inputChar){
        if(inputChar >= 97 && inputChar <= 122)
            return "lower";
        if(inputChar >= 65 && inputChar <= 90)
            return "upper";
        return "nothing";
    }
}
