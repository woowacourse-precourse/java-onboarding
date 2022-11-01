package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String, ArrayList> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            String email = form.get(0);
            String nickname = form.get(1);

            for (int j = 0; j < nickname.length()-1; j++) {
                String token = nickname.substring(j, j+2);
                if (map.containsKey(token)) {
                    ArrayList emails = map.get(token);
                    emails.add(email);
                    set.addAll(emails);
                } else {
                    map.put(token, new ArrayList(List.of(email)));
                }
            }

        }
        ArrayList<String> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
}
