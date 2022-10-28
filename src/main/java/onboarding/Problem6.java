package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<Integer>> subNicknameMap = new HashMap<>();
        for (int order = 0; order < forms.size(); order++) {
            String nickname = forms.get(order).get(1);
            List<String> subNicknames = splitNickname(nickname);
            saveSubNicknames(subNicknameMap, order, subNicknames);
        }
        Set<Integer> duplicateCrews = getDuplicateCrews(subNicknameMap);
        List<String> duplicateEmails = getDuplicateEmails(forms, duplicateCrews);
        return Collections.emptyList();
    }

    private static List<String> getDuplicateEmails(List<List<String>> forms, Set<Integer> duplicateCrews) {
        List<String> duplicateEmails = new ArrayList<>();
        for (int order : duplicateCrews) {
            duplicateEmails.add(forms.get(order).get(0));
        }
        return duplicateEmails;
    }

    private static Set<Integer> getDuplicateCrews(HashMap<String, List<Integer>> subNicknameMap) {
        Set<Integer> duplicateCrews = new HashSet<>();
        for (List<Integer> orders : subNicknameMap.values()) {
            if (orders.size() < 2) continue;
            duplicateCrews.addAll(orders);
        }
        return duplicateCrews;
    }

    private static void saveSubNicknames(HashMap<String, List<Integer>> subNicknameMap, int order, List<String> subNicknames) {
        for (String subNickname : subNicknames) {
            saveSubNickname(subNicknameMap, order, subNickname);
        }
    }

    private static void saveSubNickname(HashMap<String, List<Integer>> subNicknameMap, int order, String subNickname) {
        if (!subNicknameMap.containsKey(subNickname)) {
            subNicknameMap.put(subNickname, new ArrayList<>());
        }
        subNicknameMap.get(subNickname).add(order);
    }

    private static List<String> splitNickname(String nickname) {
        List<String> subNicknames = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            subNicknames.add(nickname.substring(i, i + 2));
        }
        return subNicknames;
    }
}
