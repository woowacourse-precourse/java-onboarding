package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static final Map<String, List<String>> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {

        initMap(forms);

        return answer;
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