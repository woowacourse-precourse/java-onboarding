package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // ex) 제이:[0,1], 이엠:[0], 이슨:[1] ...
        Map<String, List<Integer>> indexByNameMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> memberInfo = forms.get(i);
            String nickname = memberInfo.get(1);
            for (int j = 0; j < nickname.length()-1; j++) {
                String subNickname = nickname.substring(j, j + 2);
                if (indexByNameMap.containsKey(subNickname)){
                    List<Integer> memberIndexes = indexByNameMap.get(subNickname);
                    memberIndexes.add(i);
                    continue;
                }
                List<Integer> memberIndexes = new ArrayList<>();
                memberIndexes.add(i);
                indexByNameMap.put(subNickname, memberIndexes);
            }
        }

        Set<String> result = new HashSet<>();
        for (List<Integer> indexList : indexByNameMap.values()) {
            if (indexList.size() == 1) continue;
            indexList.forEach(i -> {
                List<String> memberInfo = forms.get(i);
                String email = memberInfo.get(0);
                result.add(email);
            });
        }
        List<String> resultList = new ArrayList<>(result);
        Collections.sort(resultList);

        return resultList;
    }
}
