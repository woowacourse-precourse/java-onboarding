package onboarding;

import java.util.*;

public class Problem6 {
    private static Map<String, Set<String>> nameMap = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        buildNameMap(forms);
        Set<String> answer = new HashSet<>();
        nameMap.forEach((k, v) -> {
            if (v.size() > 1) {
                answer.addAll(v);
            }
        });
        return List.copyOf(answer);
    }

    private static void buildNameMap(List<List<String>> forms) {
        forms.forEach(emailName -> {
            String email = emailName.get(0);
            String name = emailName.get(1);
            for (int i = 0; i < name.length() - 1; ++i) {
                String subName = name.substring(i, i + 2);
                if (!nameMap.containsKey(subName)) {
                    nameMap.put(subName, new HashSet<>());
                }
                nameMap.get(subName).add(email);
            }
        });
    }
}
