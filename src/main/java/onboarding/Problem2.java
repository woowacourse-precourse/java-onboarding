package onboarding;

import java.util.Stack;

public class Problem2 {

    /*
     * 문자열이 유효한 입력인지 확인합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 문자열이 유효하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(String cryptogram) {
        boolean valid =
            hasValidLength(cryptogram) &&
            isLowerCase(cryptogram);
        return valid;
    }

    /*
     * 문자열의 길이가 1~1000인지 확인합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 길이가 1~1000 사이라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidLength(String cryptogram) {
        boolean valid =
            cryptogram.length() > 0 &&
            cryptogram.length() <= 1000;
        return valid;
    }

    private static boolean isLowerCase(String cryptogram) {
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
