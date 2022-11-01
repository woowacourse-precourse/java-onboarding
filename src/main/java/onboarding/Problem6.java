package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        if (forms.size() <= 1) {
            return Collections.emptyList();
        }

        final Set<List<String>> duplicatedSet = new HashSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            final String name1 = forms.get(i).get(1);
            for (int j = i + 1; j < forms.size(); j++) {
                final String name2 = forms.get(j).get(1);
                if (isDuplicated(name1, name2)) {
                    duplicatedSet.add(forms.get(i));
                    duplicatedSet.add(forms.get(j));
                }
            }
        }

        final List<List<String>> sortDuplicatedSet = new ArrayList<>(duplicatedSet);
        sortDuplicatedSet.sort(Comparator.comparing(o -> o.get(0)));

        List<String> answer = new ArrayList<>();

        for (List<String> strings : sortDuplicatedSet) {
            answer.add(strings.get(0));
        }

        return answer;
    }

    private static boolean isDuplicated(String name1, String name2) {
        if (name1.equals(name2)) {
            return true;
        }

        for (int i = 0; i < name1.length() - 1; i++) {
            final String subName1 = name1.substring(i, i + 2);
            for (int j = 0; j < name2.length() - 1; j++) {
                final String subName2 = name2.substring(j, j + 2);
                if (subName1.equals(subName2)) {
                    return true;
                }
            }
        }
        return false;
    }
}