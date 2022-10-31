package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> resultSet = removeDup(forms);

        List<String> result = new ArrayList<>(List.copyOf(resultSet));
        result.sort(Comparator.naturalOrder());

        return result;
    }

    private static Set<String> removeDup(List<List<String>> forms) {
        Set<String> resultSet = new HashSet<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String substring = nickname.substring(i, i + 2);
                for (List<String> f : forms) {
                    if (f.equals(form)) {
                        continue;
                    }
                    if (f.get(1).contains(substring)) {
                        resultSet.add(form.get(0));
                    }
                }
            }
        }

        return resultSet;
    }
}
