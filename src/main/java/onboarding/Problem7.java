package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void putValue(HashMap<String, Set<String>> initMap, String friend1, String friend2) {
        if (!initMap.containsKey(friend1)) {
            initMap.put(friend1, new HashSet<>(Set.of(friend2)));
            return;
        }
        Set<String> tmpSet = initMap.get(friend1);
        tmpSet.add(friend2);
        initMap.put(friend1, tmpSet);
    }

}
