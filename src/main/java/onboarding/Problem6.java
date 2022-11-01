package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Boolean isThereMatch(String string) {
        Boolean result = string.matches(".*([a-zA-Z])\\1+.*");
        return result;
    }
}
