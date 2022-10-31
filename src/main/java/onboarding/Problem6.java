package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> nicknamesMap = new HashMap<>();

        List<String> nicknames = getNicknames(forms);
        for (String nickname : nicknames) {
            getSplitNicknames(nicknamesMap, nickname);
        }

        List<String> duplicateNicknames = getDuplicateNickname(nicknamesMap);
        List<String> emails = new ArrayList<>();

        for (String duplicateNickname : duplicateNicknames) {
            List<String> emailsFromNickname = findEmailsByDuplicateNickname(forms, duplicateNickname);
            emails.addAll(emailsFromNickname);
        }

        return emails;
    }

    private static List<String> getNicknames(List<List<String>> forms) {
        return forms.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList());
    }

    private static void getSplitNicknames(Map<String, Integer> nicknamesMap, String nickname) {
        int length = nickname.length();
        int sequence = 0;
        while (sequence < length - 1) {
            String splitNickname = nickname.substring(sequence, sequence + 2);
            saveSplitNickname(nicknamesMap, splitNickname);
            sequence++;
        }
    }

    private static void saveSplitNickname(Map<String, Integer> nicknamesMap, String splitNickname) {
        Set<String> splitNicknames = nicknamesMap.keySet();
        int count = 1;
        if (splitNicknames.contains(splitNickname)) {
            count = nicknamesMap.get(splitNickname) + 1;
        }
        nicknamesMap.put(splitNickname, count);
    }

    private static List<String> getDuplicateNickname(Map<String, Integer> nicknamesMap) {
        return nicknamesMap.keySet().stream()
                .filter(key -> nicknamesMap.get(key) > 1)
                .collect(Collectors.toList());
    }

    private static List<String> findEmailsByDuplicateNickname(List<List<String>> forms,
                                                              String duplicateNickname) {
        return forms.stream()
                .filter(form -> form.get(1).contains(duplicateNickname))
                .map(form -> form.get(0))
                .sorted()
                .collect(Collectors.toList());
    }
}
