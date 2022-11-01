package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();
        int formsLength = forms.size();
        for (int i = 0; i < formsLength - 1; i++) {
            for (int j = i + 1; j < formsLength - 1; j++) {
                List<String> form1 = forms.get(i);
                List<String> form2 = forms.get(j);

                String name1 = form1.get(1);
                String name2 = form2.get(1);

                if (isDupliacate(name1, name2)) {
                    emailSet.add(form1.get(0));
                    emailSet.add(form2.get(0));
                }
            }
        }

        List<String> answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    private static boolean isDupliacate(String name1, String name2) {
        int name1Length = name1.length();
        int name2Length = name2.length();
        for (int i = 0; i < name1Length - 1; i++) {
            for (int j = 0; j < name2Length - 1; j++) {
                if (name1.substring(i, i + 2).equals(name2.substring(j, j + 2))) {
                    return true;
                }
            }
        }

        return false;
    }
}
