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

/**
 * 4. 알파벳 합치는 기능
 * - char를 string에 하나씩 합치는 기능 구현
**/

/**
 * 5. 전체 기능을 실핼 시켜주는 기능
 * - switch 문을 이용한 경우의 수 함수
 * - 하나씩 읽어오는 for문 함수
 **/
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

//    public static void main(String[] args) {
//        char test = 'A';
//        String test2 = "abcedefghiqq";
//        System.out.println(converCase("TeSt",'b'));
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

    private static String appendChar(String result, char inputChar){
        result+=inputChar;
        return result;
    }

    private static String converCase(String result, char inputChar){
        String check = distinguishInput(inputChar);
        if (check.equals("lower"))
                 return appendChar(result,changeInLower(inputChar));
        else if(check.equals("upper"))
            return appendChar(result,changeInUpper(inputChar));
        return appendChar(result,inputChar);
    }

}
