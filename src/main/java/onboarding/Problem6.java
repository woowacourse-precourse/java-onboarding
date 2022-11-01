package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> result = new HashSet<>();
        Map<String, String> subName = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String userEmail = forms.get(i).get(0);
            String userName = forms.get(i).get(1);

            for (int j = 0; j < userName.length() - 1; j++) {
                String userSubName = userName.substring(j, j + 2);
                if (subName.containsKey(userSubName)) {
                    result.add(subName.get(userSubName));
                    result.add(userEmail);
                    continue;
                }

                subName.put(userSubName, userEmail);
            }
        }

        answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }
}
