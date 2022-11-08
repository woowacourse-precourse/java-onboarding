package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String,Set<String>> nicknameMap = new HashMap<>();
    private static Set<String> emailSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for(List<String> form : forms) {
            checkNickname(form);
        }
        return toSortedList(emailSet);
    }

    private static void checkNickname(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);

        for (int i = 1; i < nickname.length(); i++) {
            checkPartOfNickname(nickname.substring(i-1, i+1), email);
        }
    }

    private static void checkPartOfNickname(String part, String email) {
        if(hasDuplicatedNicknameInKeySet(part)) {
            Set<String> duplicatedEmailSet = nicknameMap.get(part);
            duplicatedEmailSet.add(email);
            emailSet.addAll(duplicatedEmailSet);
            return;
        }
        addPartOfNickToMap(part, email);

    }

    private static boolean hasDuplicatedNicknameInKeySet(String part) {
        Set<String> keySet = nicknameMap.keySet();
        if(keySet.contains(part)) {
            Set<String> emailSet = nicknameMap.get(part);
            return !emailSet.contains(part);
        }
        return false;
    }
    private static void addPartOfNickToMap(String partOfNickname, String email) {
        Set<String> newEmailSet= new HashSet<>();
        newEmailSet.add(email);
        nicknameMap.put(partOfNickname, newEmailSet);
    }

    private static List<String> toSortedList(Set<String> set) {
        List<String> newList = new ArrayList<>();
        newList.addAll(set);
        Collections.sort(newList);
        return newList;
    }
}
