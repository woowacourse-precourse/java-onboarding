package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> checkMap = createCheckMap(forms);
        List<String> duplicatedTable = createDuplicatedTable(checkMap);
        List<String> duplicatedNicknameList = findDuplicatedNickname(forms, duplicatedTable);

        return duplicatedNicknameList;
    }

    private static List<String> findDuplicatedNickname(List<List<String>> forms, List<String> duplicatedTable) {
        List<String> list = new ArrayList<>();

        for (List<String> form : forms) {
            checkingNickname(form, duplicatedTable, list);
        }
        return list.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    private static void checkingNickname(List<String> form, List<String> duplicatedTable, List<String> list) {
        for (String duplicatedWord : duplicatedTable) {
            if (form.get(1).contains(duplicatedWord)) {
                list.add(form.get(0));
            }
        }
    }

    private static List<String> createDuplicatedTable(Map<String, Integer> checkMap) {
        List<String> duplicateList = new ArrayList<>();
        for (String twoWord : checkMap.keySet()) {
            if (checkMap.get(twoWord) >= 2) {
                duplicateList.add(twoWord);
            }
        }
        return duplicateList;
    }

    private static Map<String, Integer> createCheckMap(List<List<String>> forms) {
        Map<String, Integer> checkMap = new HashMap<>();

        for (List<String> form : forms) {
            String nickName = form.get(1);
            countingWords(nickName, checkMap);
        }

        return checkMap;
    }

    private static void countingWords(String nickName, Map<String, Integer> checkMap) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String twoWord = nickName.charAt(i) + "" + nickName.charAt(i + 1);
            checkMap.put(twoWord, checkMap.getOrDefault(twoWord, 0) + 1);
        }
    }
}
