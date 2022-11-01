package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashSet<String> emails = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            String mail = form.get(0);

            if (name.length() < 2) {
                continue;
            }
            if (mail.length() < 11 || mail.length() >= 20) {
                continue;
            }
            if (!mail.contains("email.com")) {
                continue;
            }


            for (int i = 0; i < name.length() - 1; i++) {
                String key = name.substring(i, i + 2);
                if (map.containsKey(key)) {
                    String email = map.get(key);
                    if (!email.equals(form.get(0))) {
                        emails.add(email);
                        emails.add(form.get(0));
                    }

                }
                map.put(key, form.get(0));
            }
        }

        answer = emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }
}
