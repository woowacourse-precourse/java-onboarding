package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        HashMap<String, String> infoMap = parseUserInfo(forms);

        Set<String> duplicatedEmailSet = findDuplicatedNames(infoMap);

        return answer;
    }

    private static Set<String> findDuplicatedNames(HashMap<String, String> infoMap) {
        Set<String> duplicated = new HashSet<>();
        List<String> names = new ArrayList<>(infoMap.keySet());

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            boolean isDuplicate = false;

            if (name.length() < 2) continue;

            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j+2);

                for (int k = i+1; k < names.size(); k++) {
                    String compare = names.get(k);

                    if (compare.contains(key)) {
                        isDuplicate = true;
                        duplicated.add(infoMap.get(compare));
                    }
                }

                if (isDuplicate) duplicated.add(infoMap.get(name));
            }
        }

        return duplicated;
    }

    private static HashMap<String, String> parseUserInfo(List<List<String>> forms) {
        Map<String, String> result = forms.stream()
                .collect(Collectors.toMap(
                        form -> form.get(1),
                        form -> form.get(0)
                ));
        return new HashMap<>(result);
    }
}
