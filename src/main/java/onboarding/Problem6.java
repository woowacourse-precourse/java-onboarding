package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem6 {

    private static HashMap<String, String> notices = new HashMap<>();

    private static boolean getRegexMatcherResult(String expression, String target) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(target);

        return matcher.matches();
    }

    private static void isValidEmail(String email) {

        if (!getRegexMatcherResult("^[a-zA-Z0-9]{1,9}@email.com$", email)) {
            throw new Error("이메일 형식이 올바르지 않습니다.");
        }

    }

    private static void isValidNickName(String nickname) {

        if (!getRegexMatcherResult("^[가-힣]{1,19}$", nickname)) {
            throw new Error("닉네임 형식이 올바르지 않습니다.");
        }

    }

    private static boolean containConsecutiveLetters(String name1, String name2) {

        for (int i = 2; i <= name2.length(); i++) {
            String subString = name2.substring(i - 2, i);

            if (name1.contains(subString))
                return true;
        }

        return false;
    }

}
