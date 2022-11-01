package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> substrToEmail = new HashMap<>();
        SortedSet<String> duplicateEmailSet = new TreeSet<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            if (nickname.length() == 1) continue;
            addEmailOfDuplicateNickname(substrToEmail, duplicateEmailSet, nickname, email);
        }

        return new ArrayList<>(duplicateEmailSet);
    }

    private static void addEmailOfDuplicateNickname(Map<String, String> substrToEmail, Set<String> duplicateEmailSet, String nickname, String email) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String key = nickname.substring(i, j);
                if (substrToEmail.containsKey(key)) {
                    duplicateEmailSet.add(substrToEmail.get(key));
                    duplicateEmailSet.add(email);
                    continue;
                }
                substrToEmail.put(key, email);
            }
        }
    }
}
