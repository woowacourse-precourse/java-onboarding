package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final Map<String, String> usingNameMap = new HashMap<>();
    private static final Set<String> renamedListSet = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        forms.stream()
                .filter(Problem6::isCheckForms)
                .forEach(Problem6::validateSameName);

        List<String> answer = renamedListSet.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }

    private static void validateSameName(List<String> list) {
        String name = list.get(1);
        for (int i = 0; i < name.length() - 1; i++) {
            String subName = name.substring(i, i + 2);
            if (!usingNameMap.containsKey(subName)) {
                usingNameMap.put(subName, list.get(0));
            } else {
                renamedListSet.add(usingNameMap.get(subName));
                renamedListSet.add(list.get(0));
            }
        }
    }

    private static boolean isCheckForms(List<String> list) {
        return list.size() == 2
                && isCheckEmail(list.get(0))
                && isCheckName(list.get(1));
    }

    private static boolean isCheckEmail(String email) {
        return 11 <= email.length()
                && email.length() < 20
                && email.endsWith("email.com");
    }

    private static boolean isCheckName(String name) {
        return 1 <= name.length()
                && name.length() < 20
                || name.matches("[가-힣]+");
    }
}