package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> usingNameMap = new HashMap<>();
        List<String> renamedRegisters = new ArrayList<>();
        forms.stream()
                .filter(Problem6::isCheckEmailAndName)
                .forEach(list -> validateSameNameInList(list, usingNameMap, renamedRegisters));

        return renamedRegisters.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateSameNameInList(List<String> list, Map<String, String> usingNameMap, List<String> renamedListSet) {
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

    private static boolean isCheckEmailAndName(List<String> list) {
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