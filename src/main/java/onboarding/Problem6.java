package onboarding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, Integer> overlap = new HashMap<>();
        List<String> answer = new LinkedList<>();
        for (List<String> form : forms) {
            if (form.get(1).length() == 1)
                continue;
            for (int j = 0; j < form.get(1).length() - 1; j++) {
                overlap.put(form.get(1).substring(j, j + 2),
                        overlap.getOrDefault(form.get(1).substring(j, j + 2), 0) + 1);
            }
        }
        for (List<String> form : forms) {
            if (form.get(1).length() == 1)
                continue;
            for (int j = 0; j < form.get(1).length() - 1; j++) {
                if (overlap.get(form.get(1).substring(j, j + 2)) >= 2) {
                    answer.add(form.get(0).substring(0, form.get(0).length() - 10));
                    break;
                }
            }
        }
        return answer.stream()
                .distinct()
                .sorted()
                .map(it -> it + "@email.com")
                .collect(Collectors.toList());
    }
}
