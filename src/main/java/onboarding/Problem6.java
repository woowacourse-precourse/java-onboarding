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

}
