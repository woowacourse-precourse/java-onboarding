package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        forms.forEach(form -> {
            List<List<String>> duplicatedForms = forms.stream()
                    .filter(targetForm -> targetForm != form)
                    .filter(targetForm -> checkDuplicatedName(form.get(NAME), targetForm.get(NAME)))
                    .collect(Collectors.toList());

            if (!duplicatedForms.isEmpty()) {
                duplicatedForms.forEach(duplicated -> result.add(duplicated.get(EMAIL)));
                result.add(form.get(EMAIL));
            }
        });

        return result.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    static boolean checkDuplicatedName(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            String subStr = name1.substring(i, i + 2);
            if (name2.contains(subStr)) {
                return true;
            }
        }
        return false;
    }

}
