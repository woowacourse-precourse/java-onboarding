package onboarding;

import java.util.Objects;
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

    /*
     * 문자열이 모두 알파벳 소문자인지 확인합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 문자열 내 모든 문자가 알파벳 소문자라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isLowerCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            if (letter < 'a' || letter > 'z') {
                return false;
            }
        }
        return true;
    }

    /*
     * 중복된 문자들을 없애 문자열을 해독합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 해독된 문자열입니다.
     * */
    private static String decrypt(String cryptogram) {
        boolean needNextStep = true;
        int previousLength = cryptogram.length();
        while (needNextStep) {
            needNextStep = false;
            cryptogram = removeRepeatingLetters(cryptogram);
            if (cryptogram.length() != previousLength) {
                previousLength = cryptogram.length();
                needNextStep = true;
            }
        }
        return cryptogram;
    }

    /*
     * 중복된 문자들를 한 단계 제거한다.
     *
     * @param 해독할 문자열
     * @return 중복 문자들이 한 번 제거된 문자열
     * */
    private static String removeRepeatingLetters(String cryptogram) {
        Stack<Character> letters = new Stack<Character>();
        char previousLetter = ' ';
        boolean popped = false;
        for (int i = 0; i < cryptogram.length(); i++) {
            char currentLetter = cryptogram.charAt(i);
            if (currentLetter == previousLetter) {
                if (popped == false) {
                    popped = true;
                    letters.pop();
                }
                continue;
            }
            previousLetter = currentLetter;
            popped = false;
        }
        return "";
    }

    private static String stringify(String cryptogram) {
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


