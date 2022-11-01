package onboarding.common;

import onboarding.exception.InputRangeException;
import onboarding.exception.InputTypeException;

import java.util.regex.Pattern;

/**
 * 입력으로 들어온 값에 대해 공통 검증 기능을 제공하는 클래스.
 */
public class ValidationUtil {

    private String varName;

    /**
     * 오류 메시지 전달 시 사용할 입력 변수 이름 설정 메서드
     *
     * @param varName 입력한 변수 이름
     */
    public void addVarName(String varName) {
        this.varName = varName;
    }

    /**
     * 입력받은 number의 범위에 대한 검증을 진행한다.
     *
     * @param number 입력으로 들어온 number
     * @param start 시작 범위
     * @param end 끝 범위
     */
    public void checkNumRange(int number, int start, int end) {
        if (number < start || number > end) {
            if (start == end)
                throw new InputRangeException(this.varName + "은(는) " + start + "로 제한되어 있습니다.");

            throw new InputRangeException(this.varName + "은(는) " + start + "~" + end + " 사이로 제한되어 있습니다.");
        }
    }

    /**
     * 입력받은 문자열이 소문자로 구성되어 있는지 검증한다.
     *
     * @param str 입력받은 문자열
     * @param startLen 시작 길이
     * @param endLen 끝 길이
     */
    public void checkStrLowerCase(String str, int startLen, int endLen) {
        String regex = "^[a-z]{" + startLen + "," + endLen + "}$";

        if (!Pattern.matches(regex, str)) {
            throw new InputTypeException(this.varName + "의 길이는 " + startLen + "~" + endLen +
                    " 사이로 제한되어 있으며, 소문자로만 구성되어야 합니다.");
        }
    }
}
