package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String,Integer> nicknameTokensToCount = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void tokenizeNickname(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i ,i + 2);
            if (nicknameTokensToCount.containsKey(token)) {
                nicknameTokensToCount.put(token, nicknameTokensToCount.get(token) + 1);
            } else {
                nicknameTokensToCount.put(token, 1);
            }
        }
    }
}
