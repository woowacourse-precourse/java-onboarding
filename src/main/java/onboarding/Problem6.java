package onboarding;

import javax.security.auth.login.AccountLockedException;
import java.util.*;

public class Problem6 {
    private static final Map<String, List<String>> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> set = new TreeSet<>();

        clear();

        initMap(forms);

        map.forEach((s, strings) -> {
            if (strings.size() >= 2) {
                set.addAll(strings);
            }
        });

        List<String> answer = new ArrayList<>(set);
        return answer;
    }

    private static void clear() {
        map.clear();
    }

    private static void initMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                putSubstringAndEmail(nickname.substring(i, i + 2), email);
            }
        }
    }

    private static void putSubstringAndEmail(String substring, String email) {
        if (!map.containsKey(substring)) {
            map.put(substring, new ArrayList<>(List.of(email)));
            return;
        }

        map.get(substring).add(email);
        return;
    }
}