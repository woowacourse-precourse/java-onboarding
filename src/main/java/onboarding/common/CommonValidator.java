package onboarding.common;

public class CommonValidator {

    public static boolean isOnlyContainsLowerCase(String str) {
        return str.matches("^[a-z]*$");  // 소문자만 있을 때 true를 반환하는 정규식이라고 한다.
    }
}
