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
        for (String name : near) {
            for (List<String> AB : friends) {
                int point = 10;
                if (!AB.contains(user) && AB.contains(name)) {
                    int index = 1 - AB.indexOf(name);
                    if (near.contains(AB.get(index))) continue;
                    far.add(AB.get(index));
                    if (result.get(AB.get(index)) != null) {
                        point += (result.get(AB.get(index)));
                    }
                    result.put(AB.get(index), point);
                }
            }
        }
        for (String visit : visitors) {
            if (near.contains(visit)) continue;
            int point = 1;
            if (result.get(visit) != null) {
                point += (result.get(visit));
            }
            result.put(visit, point);
        }
        return answer;
    }
}
