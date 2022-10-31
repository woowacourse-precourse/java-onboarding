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
}
