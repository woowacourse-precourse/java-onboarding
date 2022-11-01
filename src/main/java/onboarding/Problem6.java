package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> duplicated_email_set = new HashSet<String>();
        HashMap<String, List<String>> duplicated_nickname_map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            int nickname_length = nickname.length();

            if (nickname_length > 1) {
                for (int i = 0; i < nickname_length - 1; i++) {
                    String banned_nickname = nickname.substring(i, i + 2);
                    if (!duplicated_nickname_map.containsKey(banned_nickname)) {
                        ArrayList<String> banned_email_list = new ArrayList<String>();
                        banned_email_list.add(email);
                        duplicated_nickname_map.put(banned_nickname, banned_email_list);
                    } else {
                        duplicated_nickname_map.get(banned_nickname).add(email);
                    }
                }
            }
        }

        duplicated_nickname_map.forEach((key, value) -> {
            if (value.size() > 1) {
                value.forEach((email) -> {
                    duplicated_email_set.add(email);
                });
            }
        });

        ArrayList<String> answer = new ArrayList<String>(duplicated_email_set);
        Collections.sort(answer);

        return answer;
    }
}
