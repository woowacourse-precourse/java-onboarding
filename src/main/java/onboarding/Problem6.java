package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static String returnBiliteralSubstring(String nickname, int index) {
        return nickname.substring(index, index+2);
    }
}
