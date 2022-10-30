package onboarding;

import java.util.List;

public class Problem6 {

    /**
     * 정규식을 통해 @email.com을 만족하는지 확인
     * @param input
     * @return
     */
    private static boolean inspectEmailCondition(String input) {
        return input.matches("/^.*@email.com$/");
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
