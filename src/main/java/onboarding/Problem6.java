package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, List<String>> mapForms = toHashMap(forms);
        List<List<String>> separateNicknameList = separateNicknameList(mapForms);
        List<String> duplicateNicknameList = getDuplicationNicknameList(separateNicknameList);
        answer = getDuplicateEmailList(mapForms, duplicateNicknameList);
        return answer;
    }

    private static Map<String, List<String>> toHashMap(List<List<String>> forms) {
        Map<String, List<String>> nicknameParts = new HashMap<>();
        for (List<String> form : forms) {
            nicknameParts.put(form.get(0), separateNickname(form.get(1)));
        }
        return nicknameParts;
    }

    public static List<String> separateNickname(String nickname) {
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            parts.add(nickname.substring(i, i + 2));
        }
        return parts;
    }

    public static List<List<String>> separateNicknameList(Map<String, List<String>> mapForms) {
        List<List<String>> duplicateNickname = new ArrayList<>();
        for (Map.Entry<String, List<String>> elements : mapForms.entrySet()) {
            duplicateNickname.add(elements.getValue());
        }
        return duplicateNickname;
    }

    public static List<String> getDuplicationNicknameList(List<List<String>> separateNicknameList) {
        List<String> duplicateNicknameList = new ArrayList<>();
        separateNicknameList.forEach(duplicateNicknameList::addAll);
        List<String> distinctList = duplicateNicknameList.stream()
                .distinct()
                .collect(Collectors.toList());
        for (String distinctElement : distinctList) {
            duplicateNicknameList.remove(distinctElement);
        }
        return duplicateNicknameList.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> getDuplicateEmailList(Map<String, List<String>> mapForms, List<String> duplicateNicknameList) {
        List<String> duplicateEmailList = new ArrayList<>();
        for (int i = 0; i < duplicateNicknameList.size(); i++) {
            for (Map.Entry<String, List<String>> stringListEntry : mapForms.entrySet()) {
                if (stringListEntry.getValue().containsAll(duplicateNicknameList.subList(i, i + 1))) {
                    duplicateEmailList.add(stringListEntry.getKey());
                }
            }
        }
        Collections.sort(duplicateEmailList);
        return duplicateEmailList.stream().distinct().collect(Collectors.toList());
    }
}
