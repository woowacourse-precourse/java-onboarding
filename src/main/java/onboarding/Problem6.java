package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, String> map;
    private static HashMap<String, Integer> duplicationCountMap;
    private static List<String> output;

    public static List<String> solution(List<List<String>> forms) {
        init();
        putFormsToMap(forms);
        addToResultIfDuplicated(forms);
        Collections.sort(output);
        return output;
    }

    private static void init() {
        map = new HashMap<>();
        duplicationCountMap = new HashMap<>();
        output = new ArrayList<>();
    }

    private static void putFormsToMap(List<List<String>> forms) {
        for (List<String> list : forms) {
            map.put(list.get(1), list.get(0));
            putDuplicationCountToMap(list.get(1));
        }
    }

    private static void putDuplicationCountToMap(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String subString = nickname.substring(i, i + 2);
            duplicationCountMap.put(subString, duplicationCountMap.getOrDefault(subString, 0) + 1);
        }
    }

    private static void addToResultIfDuplicated(List<List<String>> forms) {
        for (List<String> list : forms) {
            String nickname = list.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String subString = nickname.substring(i, i + 2);
                if (duplicationCountMap.get(subString) > 2) {
                    output.add(map.get(nickname));
                    break;
                }
            }
        }
    }
}
