package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for (List<String> form : forms) {
            String userName = form.get(1);

            if (userName.length() < 2) {
                break;
            }
            for (int j = 0; j < userName.length() - 1; j++) {
                String key = userName.substring(j, j + 2);
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

        return emails.stream().sorted().collect(Collectors.toList());
    }
}

