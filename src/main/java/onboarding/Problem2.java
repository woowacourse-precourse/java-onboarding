package onboarding;

import java.util.Stack;

public class Problem2 {

    private static boolean isValidInput(String cryptogram) {
        return false;
    }

    private static String decrypt(String cryptogram) {
        return "";
    }

    /*
     * Problem2의 솔루션 코드입니다.
     *
     * @param 해독에 사용될 문자열 입니다.
     * @return 중복글자가 제거된 문자열입니다.
     * */
    public static String solution(String cryptogram) {

        if (isValidInput(cryptogram) == false) {
            return "Error: Wrong input";
        }

        String answer = decrypt(cryptogram);
        return answer;
    }
}
