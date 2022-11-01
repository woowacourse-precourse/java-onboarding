package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> tokenAndCountMap = new HashMap<>(); // K : token, V : count
        List<Set<String>> allTokens = new ArrayList<>();

        for (int i = 0; i < allTokens.size(); i++) {
            Set<String> tokens = allTokens.get(i);
            for (String token : tokens) {
                if (tokenAndCountMap.get(token) > 1) {
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

    private static String getEmailFromCrew(List<String> eachCrew) {
        return eachCrew.get(0);
    }

    private static String getNicknameFromCrew(List<String> eachCrew) {
        return eachCrew.get(1);
    }

    private static Set<String> nicknameToTokens(String nickname) {
        Set<String> tokens = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String extractedToken = nickname.substring(i, i + 2);

            tokens.add(extractedToken);
        }

        return tokens;
    }
}
