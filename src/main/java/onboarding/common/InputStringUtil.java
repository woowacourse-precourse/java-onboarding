package onboarding.common;

/**
 * 입력으로 들어온 문자열에 대한 통합 관리 기능을 제공하는 클래스.
 */
public class InputStringUtil {

    /**
     * 문자열을 char형 배열로 분해하여 리턴한다.
     *
     * @param str 문자열
     * @return char[] - 입력으로 받은 문자열에 대해 char형 배열로 쪼갠 결과를 리턴한다.
     */
    public static char[] getCharArr(String str) {
        return str.toCharArray();

    }
}
