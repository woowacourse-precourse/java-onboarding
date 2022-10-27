package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches() && email.length() >= 11 && email.length() <= 20) {
            return true;
        }
        return false;
    }

}
