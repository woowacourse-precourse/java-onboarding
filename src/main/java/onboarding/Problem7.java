package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> recommend = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            String ID_A = friends.get(i).get(0);
            String ID_B = friends.get(i).get(1);
            if (!graph.containsKey(ID_A)) graph.put(ID_A, new ArrayList<>());
            if (!graph.containsKey(ID_B)) graph.put(ID_B, new ArrayList<>());
            graph.get(ID_A).add(ID_B);
            graph.get(ID_B).add(ID_A);
            recommend.put(ID_A, 0);
            recommend.put(ID_B, 0);
        }
        Set<String> following = new HashSet<>(graph.get(user));
        for (String friend : following)
            for (String fsf : graph.get(friend))
                if (!following.contains(fsf) && !user.equals(fsf))
                    recommend.put(fsf, recommend.get(fsf) + 10);
        for (String visitor : visitors) {
            if (following.contains(visitor)) continue;
            if (!recommend.containsKey(visitor)) recommend.put(visitor, 0);
            recommend.put(visitor, recommend.get(visitor) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String id : recommend.keySet())
            if (recommend.get(id) > 0) result.add(id);
        Collections.sort(result,
                (id1, id2) -> recommend.get(id2) != recommend.get(id1) ? recommend.get(id2).compareTo(recommend.get(id1)) : id1.compareTo(id2));
        for (int i = 0; i < result.size() && i < 5; i++)
            answer.add(result.get(i));
        return answer;
    }
}