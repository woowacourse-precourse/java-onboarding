package onboarding;

import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void initializeSubstringMap(List<List<String>> forms, Map<String, Integer> substringMap) {
        for (List<String> crew : forms) {
            String nickname = crew.get(1);
            for (int i = 0; i < nickname.length()-1; i++) {
                String substring = nickname.substring(i, i + 2);
                if (substringMap.containsKey(substring)) {
                    substringMap.put(substring, substringMap.get(substring) + 1);
                } else{
                    substringMap.put(substring, 1);
                }
            }
        }
    }

    private static void extractDuplicateSubstring(List<String> answer, List<List<String>> forms,
                                                  Map<String, Integer> substringMap) {

    }
}
