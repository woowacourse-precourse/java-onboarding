package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> duplicateMap = new HashMap<>();
        Set<String> deduplicatedEmail = new LinkedHashSet<>();

        return answer;
    }

    private static void addValueToSet(Map<String, List<String>> duplicateMap, Set<String> duplicatedEmail) {
        duplicatedEmail.addAll(duplicateMap.values().stream()
                .filter(emailList -> emailList.size() >= 2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    private static String getTwoDigitName(String nickname, int startIdx) {
        return nickname.substring(startIdx, startIdx + 2);
    }
}
