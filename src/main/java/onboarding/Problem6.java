package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static HashMap<String, Integer> getTwoCharAndCountHashMap(List<String> item) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= item.get(1).length() - 2; i++) {
            if (map.get(item.get(1).substring(i, i + 2)) == null) {
                map.put(item.get(1).substring(i, i + 2), 1);
            } else {
                map.put(item.get(1).substring(i, i + 2), map.get(item.get(1).substring(i, i + 2)) + 1);
            }
        }
        return map;
    }

    private static HashMap<String, Integer> getNicknameAndCountHashMap(List<List<String>> forms) {
        HashMap<String, Integer> nicknameAndCountHashMap = new HashMap<>();

        for (List<String> item : forms) {
            getTwoCharAndCountHashMap(item).forEach((key, value) -> nicknameAndCountHashMap.merge(key, value, Integer::sum));
        }
        return nicknameAndCountHashMap;
    }

}
