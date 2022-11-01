package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class Problem6 {
    private static List<String> checkNickname(List<List<String>> forms, List<String> answer) {
        String targetName;
        String comparedName;
        String duplicated;

        for (int i = 0; i < forms.size() - 1; i++) {
            targetName = forms.get(i).get(1);

            for (int j = 0; j < targetName.length() - 2; j++) {
                duplicated = targetName.substring(j, j+2);

                for (int k = i + 1; k < forms.size(); k++) {
                    comparedName = forms.get(k).get(1);
                    if (comparedName.contains(duplicated)) {
                        answer.add(forms.get(i).get(0));
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        return answer;
    }

    private static List<String> cleanAndOrder(List<String> answer) {
        TreeSet<String> set = new TreeSet<>(answer);
        answer = new ArrayList<>(set);

        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        answer = checkNickname(forms, answer);
        answer = cleanAndOrder(answer);

        return answer;
    }
}
