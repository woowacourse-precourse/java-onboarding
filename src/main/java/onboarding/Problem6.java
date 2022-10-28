package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findConsecutiveLetters(forms);

        return answer.stream().distinct().sorted(String::compareTo).collect(Collectors.toList());

    }


    private static List<String> findConsecutiveLetters(List<List<String>> forms) {
        List<String> duplicated = new ArrayList<>();
        Map<String, Integer> tmp = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            if(nickName.length() < 2) continue;
            checkDuplicated(forms, duplicated, tmp, i, nickName);
        }
        return duplicated;
    }

    private static void checkDuplicated(List<List<String>> forms, List<String> duplicated, Map<String, Integer> tmp, int index, String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String subName = nickName.substring(i, i + 2);
            if (!tmp.containsKey(subName)) tmp.put(subName, index);
            else {
                duplicated.add(forms.get(index).get(0));
                duplicated.add(forms.get(tmp.get(subName)).get(0));
            }
        }
    }
}
