package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> nameEmailInfo = new HashMap<>();
        Map<String, Set<String>> duplicateCheckMap = new HashMap<>();
        Set<String> duplicatedNames = new HashSet<>();

        for (List<String> form : forms) {
            nameEmailInfo.putIfAbsent(form.get(1), new HashSet<>());
            nameEmailInfo.get(form.get(1)).add(form.get(0));
        }

        for (String name : nameEmailInfo.keySet()) {
            for (int i = 0, nameLen = name.length(); i + 1 < nameLen; i++) {
                duplicateCheckMap.putIfAbsent(name.substring(i, i + 2), new HashSet<>());
                duplicateCheckMap.get(name.substring(i, i + 2)).add(name);
            }
        }

        for (Set<String> names : duplicateCheckMap.values()) {
            if (names.size() > 1) {
                duplicatedNames.addAll(names);
            }
        }

        for (String name : duplicatedNames) {
            answer.addAll(nameEmailInfo.get(name));
        }

        answer.sort(String::compareTo);

        return answer;
    }
}
