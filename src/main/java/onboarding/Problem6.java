package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length()-1; i++) {
                String subName = name.substring(i, i+2);
                wordsMap.put(subName, wordsMap.getOrDefault(subName, 0)+1);
            }
        }
        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length()-1; i++) {
                String subName = name.substring(i, i+2);
                if (wordsMap.get(subName)-1 > 0) {
                    answer.add(form.get(0));
                    break;
                }
            }
        }

        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }
}
