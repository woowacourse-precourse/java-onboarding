package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static List<String> search(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);
                if(containSameLetters(name1, name2)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = search(forms);

        answer = answer.stream()
                .distinct().sorted()
                .collect(Collectors.toList());

        return answer;
    }
}
