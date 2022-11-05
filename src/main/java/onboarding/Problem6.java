package onboarding;

import java.util.*;
import java.util.stream.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();

        Map<String, String> crewMap = new HashMap<>();

        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                crewMap.put(form.get(1), form.get(0));
            }
        }
        Set<String> nicknameSet = crewMap.keySet();
        nicknameSet.forEach(i -> {
            for (int j = 0; j < i.length() - 1; j++) {
                String consecutiveLetter = i.substring(j, j + 2);
                nicknameSet.forEach(k -> {
                    if (!k.equals(i) && k.contains(consecutiveLetter)) result.add(crewMap.get(k));});
            }
        });
        return result.stream().distinct().sorted().collect(Collectors.toList());
    }
}
