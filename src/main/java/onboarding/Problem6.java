package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, String> check = new HashMap<>();
        Set<String> emails = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            if (nickname.length() < 2) continue;
            for (int j = 0; j < nickname.length() - 1; j++) {
                String letters = nickname.substring(j, j + 2);
                if (check.containsKey(letters) &&
                        !email.equals(check.get(letters))) {
                    emails.add(email);
                    emails.add(check.get(letters));
                }
                check.put(letters, email);
            }
        }
        answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }
}