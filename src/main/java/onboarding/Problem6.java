package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, Integer> getDuplicatedStringCounts(List<List<String>> forms) {
        Map<String, Integer> stringCount = new HashMap<>();
        for (List<String> crew : forms) {
            countSubStringInName(stringCount, crew.get(1));
        }
        return stringCount;
    }

    private static void countSubStringInName(Map<String, Integer> stringCount, String name) {
        for (int start = 0; start < name.length(); start++) {
            for (int end = start + 1; end < name.length(); end++) {
                putSubString(stringCount, name, start, end);
            }
        }
    }

    private static void putSubString(Map<String, Integer> stringCount, String name, int start, int end) {
        stringCount.put(name.substring(start, end + 1), stringCount.getOrDefault(name.substring(start, end + 1), 0));
    }

    public List<String> getDuplicatedStringList(Map<String, Integer> stringCount) {
        return stringCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
