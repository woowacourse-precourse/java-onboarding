package onboarding.problem2.service;

import onboarding.problem2.validation.CryptogramValidator;

/**
 * 괴짜 개발자 브라운의 암호문 해독 알고리즘과 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class CryptogramService {
    public static final String REPEATING_MORE_THAN_ONCE_REGEX = "(.)\\1+";

    /**
     * 인자로 들어온 문자열을 해독 알고리즘에 따라 해독 후 결과물을 반환하는 메소드입니다.
     * @param cryptogram 해독할 문자열을 인자로 받습니다.
     * @return 해독이 완료된 결과물입니다.
     */
    public static String decodeCryptogram(String cryptogram) {
        CryptogramValidator.validate(cryptogram);
        cryptogram = removeSpacing(cryptogram);
        return removeDuplicated(cryptogram);
    }

    /**
     * 문자열에 있는 공백을 모두 제거하는 메소드입니다.
     * @return 공백이 제거된 문자열을 반환합니다.
     */
    private static String removeSpacing(String target) {
        return target.replaceAll(" ", "");
    }

    /**
     * 괴짜 개발자 브라운의 해독 알고리즘 메소드입니다.
     * 연속으로 중복된 문자열을 제거한 후 해당 메소드를 재귀적으로 호출하면서 더이상 제거할 중복 문자열이 없을 때까지 반복합니다.
     * @param target 중복을 제거할 문자열을 인자로 받습니다.
     * @return 해독이 완료된 결과물을 리턴합니다.
     */
    private static String removeDuplicated(String target) {
        String result = target.replaceAll(REPEATING_MORE_THAN_ONCE_REGEX, "");
        if (isWordLengthChanged(target, result)) {
            result = removeDuplicated(result);
        }
        return result;
    }

    /**
     * 중복 문자열 제거 후, 제거 대상과 제거 결과 문자열에 변화가 있었는 지 체크하는 메소드입니다.
     * @param target 중복 문자열 제거 작업 이전의 문자열입니다.
     * @param result 중복 문자열 제거 작업 이후의 문자열입니다.
     */
    private static boolean isWordLengthChanged(String target, String result) {
        return !target.equals(result);
    }
}
