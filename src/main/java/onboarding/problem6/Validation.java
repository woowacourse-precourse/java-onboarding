package onboarding.problem6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    /*
     * 정규표현식 검사 기능
     */
    private static boolean getRegexMatcherResult(String expression, String target) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(target);

        return matcher.matches();
    }

    /*
     * 이메일 형식 검증 기능
     */
    public static void isValidEmail(String email) {

        if (!getRegexMatcherResult("^[a-zA-Z0-9]{1,9}@email.com$", email)) {
            throw new Error("이메일 형식이 올바르지 않습니다.");
        }

    }

    /*
     * 닉네임 형식 검증 기능
     */
    public static void isValidNickName(String nickname) {

        if (!getRegexMatcherResult("^[가-힣]{1,19}$", nickname)) {
            throw new Error("닉네임 형식이 올바르지 않습니다.");
        }

    }
}
