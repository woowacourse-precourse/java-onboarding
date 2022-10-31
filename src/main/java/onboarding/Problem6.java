package onboarding;


import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String email;
        String name;
        Set<String> removeSet;
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        List<String> subStrList;
        String subStr;
        for (List<String> form : forms) {
            email = form.get(0);
            name = form.get(1);

            for (int j = 0; j < name.length() - 1; j++) {
                subStr = name.substring(j, j + 2);
                list = new ArrayList<>(List.of(email));
                if (map.containsKey(subStr)) {
                    subStrList = map.get(subStr);
                    list.addAll(subStrList);
                }
                map.put(subStr, list);
            }
        }

        for (List<String> value : map.values()) {
            if (value.size() > 1) {
                answer.addAll(value);
            }
        }
        removeSet = new TreeSet<>(answer);
        answer = new ArrayList<>(removeSet);
        return answer;
    }
}
