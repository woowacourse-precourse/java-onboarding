package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> list : forms) {
            String email = list.get(0);
            String id = list.get(1);
            for (int i = 0; i < id.length() - 1; i++) {
                String key = id.substring(i, i + 2);
                if (map.containsKey(key)) {
                    answer.add(email);
                    if (!answer.contains(map.get(key))) {
                        answer.add(map.get(key));
                    }
                    break;
                }
                map.put(key, email);

            }
        }

        return answer;
    }
}
