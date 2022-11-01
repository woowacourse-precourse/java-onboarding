package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> tokenAndCountMap = new HashMap<>(); // K : token, V : count
        List<Set<String>> allTokens = new ArrayList<>();

        setTokenAndCountMap(forms, tokenAndCountMap, allTokens);

        for (int i = 0; i < allTokens.size(); i++) {
            Set<String> tokens = allTokens.get(i);
            for (String token : tokens) {
                if (isDuplicatedToken(tokenAndCountMap, token)) {
                    List<String> eachCrew = forms.get(i);
                    String email = getEmailFromCrew(eachCrew);
                    answer.add(email);
                    break;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    private static void setTokenAndCountMap(List<List<String>> forms,
                                            Map<String, Integer> tokenAndCountMap,
                                            List<Set<String>> allTokens) {

        for (List<String> eachCrew : forms) {
            String nickname = getNicknameFromCrew(eachCrew);
            Set<String> tokens = nicknameToTokens(nickname);

            addTokenAndCountToMap(tokenAndCountMap, tokens);

            allTokens.add(tokens); // Set<String> -> List<Set<String>>
        }
    }

    private static String getEmailFromCrew(List<String> eachCrew) {
        return eachCrew.get(0);
    }

    private static String getNicknameFromCrew(List<String> eachCrew) {
        return eachCrew.get(1);
    }

    private static boolean isDuplicatedToken(Map<String, Integer> tokenAndCountMap, String token) {
        return tokenAndCountMap.get(token) > 1;
    }

    private static Set<String> nicknameToTokens(String nickname) {
        Set<String> tokens = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String extractedToken = nickname.substring(i, i + 2);

            tokens.add(extractedToken);
        }

        return tokens;
    }

    private static void addTokenAndCountToMap(Map<String, Integer> tokenAndCountMap,
                                              Set<String> tokens) {
        for (String token : tokens) {
            tokenAndCountMap.put(token, tokenAndCountMap.getOrDefault(token, 0) + 1);
        }
    }
}
