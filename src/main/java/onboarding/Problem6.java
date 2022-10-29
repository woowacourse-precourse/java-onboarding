package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static boolean isEmailDotCom(String s) {
        String pattern = "^[a-zA-Z0-9]*@email.com";
        return s.matches(pattern);
    }
}
