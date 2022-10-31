package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Problem7 problem = new Problem7();
        HashMap<String, Integer> listpeople;

        listpeople = problem.extractPeopleMap(user, friends, visitors);

        return answer;
    }

    public HashMap<String, Integer> extractPeopleMap(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> result = new HashMap<>();

        for(List e : friends) {
            for(Object s : e) {
                result.put((String) s, 0);
            }
        }

        for(String e : visitors) {
            result.put(e, 0);
        }

        result.remove(user);

        return result;
    }
}
