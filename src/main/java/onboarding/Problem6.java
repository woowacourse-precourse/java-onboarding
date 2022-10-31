package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    private static final String DOMAIN = "@email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        
        return answer;
    }

    private static boolean isMatchWithOther(String myEmail, String targetSubNickName, List<List<String>> forms) {
        for (List<String> member : forms){
            if (member.get(0).equals(myEmail)){
                continue;
            }
            if (checkDuplicate(targetSubNickName, member.get(1))){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDuplicate(String targetSubNickName, String otherNickName){
        String regex = ".*" + targetSubNickName + ".*";
        return Pattern.matches(regex, otherNickName);
    }
}
