package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> near = new ArrayList<>();
        Set<String> far = new HashSet<>();
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (List<String> AB : friends) {
            if (AB.contains(user)) {
                int index = 1 - AB.indexOf(user);
                near.add(AB.get(index));
            }
        }
        return answer;
    }
}
