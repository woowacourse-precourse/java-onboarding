package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        for (List<String> form : forms) {
            String nickname = form.get(1);
            nicknameToToken(nickname);
        }
        return answer;
    }

    private static Set<String> nicknameToToken(String nickname) {
        Set<String> tokens = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String nicknameToken = nickname.substring(i, i + 2);
            tokens.add(nicknameToken);
        }
        return tokens;
    }
}
