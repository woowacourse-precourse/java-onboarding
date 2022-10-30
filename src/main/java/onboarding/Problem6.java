package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length()-1; i++) {
                String target = nickname.substring(i, i+2);
                if (map.get(target) == null) {
                    map.put(target, new ArrayList<>());
                }
                map.get(target).add(email);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                for (int i = 0; i < map.get(key).size(); i++) {
                    answer.add(map.get(key).get(i));
                }
            }
        }
        return new ArrayList<>(answer);
    }
}
