package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emailSet = new HashSet<>();
        HashMap<String, String> tokens = new HashMap<>();


        for (List<String> crewInfo : forms) {
            String secondElement = crewInfo.get(1);
            char[] nickname = secondElement.toCharArray();
            for (int i = 0; i < nickname.length - 1; i++) {
                String token = "";
                token += nickname[i];
                token += nickname[i + 1];

                if (tokens.containsKey(token)) {
                    emailSet.add(tokens.get(token));
                    emailSet.add(crewInfo.get(0));
                } else {
                    tokens.put(token, crewInfo.get(0));
                }
            }
        }

        ArrayList<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }
}
