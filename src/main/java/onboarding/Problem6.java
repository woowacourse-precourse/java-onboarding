package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> results = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            List<StringBuilder> list = new ArrayList<>();

            for (int j = 1; j < forms.get(i).get(1).length(); j++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(forms.get(i).get(1).charAt(j - 1)).append(forms.get(i).get(1).charAt(j));
                list.add(stringBuilder);
            }

            for (int j = i + 1; j < forms.size(); j++) {
                for (StringBuilder stringBuilder : list) {
                    if (forms.get(j).get(1).contains(stringBuilder)) {
                        results.add(forms.get(j).get(0));
                        results.add(forms.get(i).get(0));
                        break;
                    }
                }

            }
        }

        List<String> answer = new ArrayList<>(results);
        Collections.sort(answer);
        return answer;
    }

}
