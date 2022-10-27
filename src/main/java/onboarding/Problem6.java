package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> findDuplicatedWord(List<List<String>> forms) {
        Map<String, Integer> map = new HashMap<>();
        List<String> duplicatedWord = new ArrayList<>();

        for (List<String> form : forms) {
            String crewName = form.get(1);
            for (int j = 0; j < crewName.length() - 1; j++) {
                String subName = crewName.substring(j, j + 2);
                map.put(subName, map.getOrDefault(subName, 0) + 1);
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 1)
                duplicatedWord.add(s);
        }
        return duplicatedWord;
    }
}
