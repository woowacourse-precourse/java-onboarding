package onboarding;

import onboarding.common.InputStringUtil;
import onboarding.exception.InputRangeException;
import onboarding.exception.InputTypeException;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 입력 문자에 대한 제한사항을 검증한다.
        checkCryptogramValidation(cryptogram);

        // 입력 문자열을 char형 배열로 분해한다.
        char[] cryptogramArr = InputStringUtil.getCharArr(cryptogram);

        // 배열을 순회하며 해당 원소를 기준으로 중복 문자열을 체크한다.
        for(Character element : cryptogramArr) {
            // 해당 문자가 2번 이상 반복된다면 제거하여 원본 암호문을 변경한다.
            cryptogram = removeDuplicateElement(cryptogram, element);
        }

        return cryptogram;
    }

    /**
     * 입력 암호문에 대한 검증을 진행한다.
     *
     * @param cryptogram 입력 암호문
     */
    private static void checkCryptogramValidation(String cryptogram) {
        // 문자열의 길이를 검증한다.
        if(isNotStrLengthRange(cryptogram)) {
            throw new InputRangeException("문자열의 길이는 1~1000 사이여야 합니다.");
        }

        // 소문자인지 검증한다.
        if(isNotUpperCase(cryptogram)) {
            throw new InputTypeException("입력 문자열은 소문자여야 합니다.");
        }
    }

    /**
     * 암호문의 길이에 대해 검증을 진행한다.
     *
     * @param cryptogram 입력 암호문
     * @return 1~1000 사이를 벗어난다면 true, 아니라면 false
     */
    private static boolean isNotStrLengthRange(String cryptogram) {
        return cryptogram.length() < 1 || cryptogram.length() > 1000;
    }

    /**
     * 암호문이 소문자으로 구성되어 있는지 검증을 진행한다.
     *
     * @param cryptogram 입력 암호문
     * @return 소문자가 아닌 문자가 있다면 false, 아니라면 true
     */
    private static boolean isNotUpperCase(String cryptogram) {
        String regex = "^[a-z]{1,1000}$";

        return !Pattern.matches(regex, cryptogram);
    }

    /**
     * 2번 이상 중복된 문자열을 제거한다.
     *
     * @param cryptogram 제거 진행할 문자열
     * @param element 제거의 기준이 되는 요소
     * @return String - 제거 작업이 완료된 문자열을 리턴한다.
     */
    private static String removeDuplicateElement(String cryptogram, Character element) {
        return cryptogram.replaceAll(element + "{2,}", "");
    }
}
