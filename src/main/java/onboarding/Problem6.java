package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static void addPartialNickname(String nickname, HashMap<String, Integer> counter) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String partialNickname = nickname.substring(i, i + 2);
            int count = counter.getOrDefault(partialNickname, 0);
            counter.put(partialNickname, count + 1);
        }
    }
}