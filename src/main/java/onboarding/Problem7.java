package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> relation = new HashMap<>();
        for (List<String> list : friends) {
            String f1 = list.get(0);
            String f2 = list.get(1);
            ArrayList<String> arr = new ArrayList<>();
            if (!relation.containsKey(f1)){
                relation.put(f1, new ArrayList<>());
            }
            if (!relation.containsKey(f2)){
                relation.put(f2, new ArrayList<>());
            }
            relation.get(f1).add(f2);
            relation.get(f2).add(f1);
        }

        return answer;
    }
}
