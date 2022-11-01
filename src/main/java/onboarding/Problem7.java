package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    private static void appendMapValue(String key, String appendValue,
        HashMap<String, List<String>> map) {
        List<String> values = map.getOrDefault(key, new ArrayList<>());
        values.add(appendValue);
        map.put(key, values);
    }

    private static void updateMapValue(String key, int addScore, HashMap<String, Integer> map) {
        map.put(key, map.getOrDefault(key, 0) + addScore);
    }

    private static void updateMapAll(List<String> keys, int addScore,
        HashMap<String, Integer> map) {
        keys.forEach(key -> updateMapValue(key, addScore, map));
    }

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
