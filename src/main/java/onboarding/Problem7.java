package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String, Integer> point = new HashMap<>();

        for (List<String> friend : friends) {
            point.put(friend.get(1),
                    point.getOrDefault(friend.get(1), 0) + 10);
        }

        for (String visitor : visitors) {
            point.put(visitor,
                    point.getOrDefault(visitor, 0) + 1);
        }

        for (List<String> friend : friends) {
            if (friend.get(1).equals(user))
                point.remove(friend.get(0));
        }
        point.remove(user);


        List<String> answer = new ArrayList<>(point.keySet());
        answer.sort((o1, o2) -> {
            if (point.get(o2).equals(point.get(o1))) {
                return o1.compareTo(o2);
            } else return point.get(o2) - point.get(o1);
        });

        if (answer.size() >= 6) {
            answer.subList(6, answer.size() + 1).clear();
        }
        return answer;
    }
}
