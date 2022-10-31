package onboarding;

import java.util.*;

public class Problem6 {
    private static final Map<String, Set<String>> patternMatchedEmailStorage = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();

        forms.forEach(userInfo -> {
            String email = userInfo.get(0);
            String username = userInfo.get(1);

            savePattern(email, username);
        });

    }

    private static void savePattern(String email, String username) {
        for (int i = 0; i < username.length()-1; i++) {
            String pattern = username.substring(i, i + 2);

            Set<String> emailSet = patternMatchedEmailStorage.get(pattern);
            if (emailSet == null) {
                emailSet = new HashSet<>();
                patternMatchedEmailStorage.put(pattern, emailSet);
            }
            emailSet.add(email);
        }
    }
}
