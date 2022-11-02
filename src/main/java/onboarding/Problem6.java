package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Map<String, String> map = new HashMap<>();
        Set<String> set = new TreeSet<>();

        for (List<String> form : forms) {
            String target = form.get(1);
            for (int j = 0; j < target.length() - 1; j++) {
                String str = target.substring(j, j + 2);
                String curEmail = form.get(0);
                if (!map.containsKey(str)) {
                    map.put(target.substring(j, j + 2), form.get(0));
                } else {
                    set.add(curEmail);
                    set.add(map.get(str));
                }
            }
        }

        answer = new ArrayList<>(set);

        return answer;
    }
}
