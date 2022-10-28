package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<Integer>> twoConsecutiveLetters = findConsecutiveLetters(forms);

        for (List<Integer> list : twoConsecutiveLetters.values()) {
            if (list.size() < 2) continue;
            for (int idx : list) {
                answer.add(forms.get(idx).get(0));
            }
        }

        return answer.stream().distinct().sorted(String::compareTo).collect(Collectors.toList());

    }

    private static Map<String, List<Integer>> findConsecutiveLetters(List<List<String>> forms) {
        Map<String, List<Integer>> tmp = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            for (int j = 0; j < nickName.length() - 1; j++) {
                tmp.computeIfAbsent(nickName.substring(j, j + 2), s -> new ArrayList<>()).add(i);
            }
        }
        return tmp;
    }
}
