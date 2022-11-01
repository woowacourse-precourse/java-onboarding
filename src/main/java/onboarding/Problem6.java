package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> nicknameAndCountHashMap = getNicknameAndCountHashMap(forms);
        List<String> list = getDuplicatedList(nicknameAndCountHashMap);
        List<String> answer = getDuplicatedNicknameList(list, forms);
        Collections.sort(answer);
        return answer;
    }
    public static HashMap<String, Integer> getTwoCharAndCountHashMap(List<String> item) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= item.get(1).length() - 2; i++) {
            if (map.get(item.get(1).substring(i, i + 2)) == null) {
                map.put(item.get(1).substring(i, i + 2), 1);
            } else {
                map.put(item.get(1).substring(i, i + 2), map.get(item.get(1).substring(i, i + 2)) + 1);
            }
        }
        return map;
    }
    public static HashMap<String, Integer> getNicknameAndCountHashMap(List<List<String>> forms) {
        HashMap<String, Integer> nicknameAndCountHashMap = new HashMap<>();

        for (List<String> item : forms) {
            getTwoCharAndCountHashMap(item).forEach((key, value) -> nicknameAndCountHashMap.merge(key, value, Integer::sum));
        }
        return nicknameAndCountHashMap;
    }

    public static List<String> getDuplicatedList(HashMap<String, Integer> map) {
        List<String> duplicatedList = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                duplicatedList.add(key);
            }
        }
        return duplicatedList;
    }

    public static ArrayList<String> getDuplicatedNickname(List<List<String>> forms, String item) {
        ArrayList<String> list = new ArrayList<>();
        for (List<String> items : forms) {
            if (items.get(1).contains(item))
                list.add(items.get(0));
        }
        return list;
    }
    public static List<String> getDuplicatedNicknameList(List<String> duplicatedList, List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        for (String item : duplicatedList) {
            answer.addAll(getDuplicatedNickname(forms, item));
        }
        return answer;
    }
}
