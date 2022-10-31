package onboarding;

import onboarding.common.InputStringUtil;
import onboarding.common.ValidationUtil;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 입력 암호문 대한 제한사항을 검증한다.
        verifyCryptogram(cryptogram);

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
     * 입력받은 암호문에 대한 검증 작업을 진행한다.
     *
     * @param cryptogram 입력 암호문
     */
    private static void verifyCryptogram(String cryptogram) {
        // 암호문의 길이는 1~1000 사이로 제한되어 있다.
        ValidationUtil cryptogramValidation = new ValidationUtil();
        cryptogramValidation.addVarName("cryptogram");
        cryptogramValidation.checkStrLowerCase(cryptogram, 1, 1000);
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
