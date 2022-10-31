package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<>();

        for (List<String> pair : friends) {
            if (pair.get(0).equals(user)) {
                userFriends.add(pair.get(1));
            }
            if (pair.get(1).equals(user)) {
                userFriends.add(pair.get(0));
            }
        }

        for (List<String> pair : friends) {
            if (userFriends.contains(pair.get(0))) {
                score.put(pair.get(1), score.containsKey(pair.get(1)) ? score.get(pair.get(1)) + 10 : 10);
            }
            if (userFriends.contains(pair.get(1))) {
                score.put(pair.get(0), score.containsKey(pair.get(0)) ? score.get(pair.get(0)) + 10 : 10);
            }
        }

        userFriends.add(user);

        for (String friend : userFriends) {
            score.remove(friend);
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                score.put(visitor, score.containsKey(visitor) ? score.get(visitor) + 1 : 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(score.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        while ((answer.size() < 5) && !entries.isEmpty()) {
            answer.add(entries.remove(0).getKey());
        }

        return answer;
    }
}
