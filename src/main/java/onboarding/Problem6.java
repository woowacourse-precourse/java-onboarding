package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<Integer>> subNicknameMap = new HashMap<>();
        for (int order = 0; order < forms.size(); order++) {
            String nickname = forms.get(order).get(1);
            List<String> subNicknames = splitNickname(nickname);
            saveSubNicknames(subNicknameMap, order, subNicknames);
        }
        return Collections.emptyList();
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
