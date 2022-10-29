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

/**
 * 2. 소문자 알파벳 변환 기능
 * - Ascii code상 a ~ z 는 97 ~ 122
 * - a와 z의 합을 통해 변환
 */

/**
 * 3. 대문자 알파벳 변환 기능
 * - Ascii code상 A ~ Z 는 65 ~ 90
 * - A와 Z의 합을 통해 변환
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
//
//    public static void main(String[] args) {
//        char test = 'A';
//        String test2 = "abcedefghiqq";
//        System.out.println(appendChar(test,test2));
//    }

    private static String distinguishInput(char inputChar){
        if(inputChar >= 97 && inputChar <= 122)
            return "lower";
        if(inputChar >= 65 && inputChar <= 90)
            return "upper";
        return "nothing";
    }

    private static char changeInLower(char inputChar){
         int sumOfaz = 122 + 97;
         char ret = (char)(sumOfaz-inputChar);
         return ret;
    }

    private static char changeInUpper(char inputChar){
        int sumOfAZ = 90 + 65;
        char ret = (char)(sumOfAZ-inputChar);
        return ret;
    }

    private static String appendChar(char inputChar, String result){
        result+=inputChar;
        return result;
    }

}
