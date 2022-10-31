package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    private static final String DOMAIN = "@email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }

    private static boolean checkDuplicate(String targetSubNickName, String otherNickName){
        String regex = ".*" + targetSubNickName + ".*";
        return Pattern.matches(regex, otherNickName);
    }
}
