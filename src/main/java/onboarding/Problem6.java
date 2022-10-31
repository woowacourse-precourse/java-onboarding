package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static void findDuplication(List<String> form, Map<String, String> tokens, Set<String> answer) {
        String email = form.get(0);
        String nickname = form.get(1);

        if (nickname.length() == 1)
            return;

        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i + 2);
            if (tokens.containsKey(token)) {
                answer.add(tokens.get(token));
                answer.add(email);
                continue;
            }
            tokens.put(token, email);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> tokens = new HashMap<>();
        Set<String> answer = new HashSet<>();

        forms.forEach(o -> findDuplication(o, tokens, answer));
        return answer.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
