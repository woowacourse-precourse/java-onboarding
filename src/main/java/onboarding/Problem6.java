package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Set<String>> tokensList = new ArrayList<>();
        Map<String, Integer> tokenToCount = new HashMap<>();

        forms.stream()
                .map(f -> nicknameToToken(f.get(1)))
                .forEach(tokens -> {
                    tokensList.add(tokens);
                    tokens.forEach(token ->
                            tokenToCount.put(token, tokenToCount.getOrDefault(token, 0) + 1));
                });

        for (int i = 0; i < tokensList.size(); i++) {
            if (tokensList.get(i).stream().anyMatch(token -> tokenToCount.get(token) > 1)) {
                answer.add(forms.get(i).get(0));
            }
        }

        answer.sort(String::compareTo);
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
