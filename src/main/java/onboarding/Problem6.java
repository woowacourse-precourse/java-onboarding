package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> getNicknamesInForms(List<List<String>> forms) {
        return forms.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList());
    }

    private static void getSplitNicknames(Map<String, Integer> nicknamesMap, String nickname) {
        int length = nickname.length();
        int sequence = 0;
        while (sequence < length - 1) {
            String splitNickname = nickname.substring(sequence, sequence + 2);
            insertNickname(nicknamesMap, splitNickname);
            sequence++;
        }
    }

    private static void insertNickname(Map<String, Integer> nicknamesMap, String splitNickname) {
        Set<String> splitNicknames = nicknamesMap.keySet();
        if (splitNicknames.contains(splitNickname)) {
            Integer count = nicknamesMap.get(splitNickname);
            nicknamesMap.replace(splitNickname, count + 1);
        } else {
            nicknamesMap.put(splitNickname, 1);
        }
    }

    private static List<String> checkDuplicateNickname(Map<String, Integer> nicknamesMap) {
        return nicknamesMap.keySet().stream()
                .filter(key -> nicknamesMap.get(key) > 1)
                .collect(Collectors.toList());
    }

    private static List<String> findEmailsByDuplicateNickname(List<List<String>> forms, String getDuplicateNickname) {
        return forms.stream()
                .filter(form -> form.get(1).contains(getDuplicateNickname))
                .map(form -> form.get(0))
                .sorted()
                .collect(Collectors.toList());
    }
}
