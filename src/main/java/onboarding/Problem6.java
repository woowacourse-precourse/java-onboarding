package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void nickNameCombination(String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String combination = nickName.substring(i, i + 2);
        }
    }
}
