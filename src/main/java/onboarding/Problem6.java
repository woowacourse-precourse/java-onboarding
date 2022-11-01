package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Boolean isThereMatch(String string, keyword) {
        String regex = ".*("+keyword+")+.*";
        Boolean result = string.matches(regex);
        return result;
    }
}
