package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();

        // get list of user's friends
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                String friend = relation.get(0).equals(user) ? relation.get(1) : relation.get(0);
                friendsOfUser.add(friend);
            }
        }

        // calculate 'friends both know' score
        for (List<String> relation : friends) {
            if (relation.contains(user)) {
                continue;
            }
            for (String friend : friendsOfUser) {
                if (relation.contains(friend)) {
                    String target = relation.get(0).equals(friend) ? relation.get(1) : relation.get(0);
                    if (scores.containsKey(target)) {
                        scores.put(target, scores.get(target) + 10);
                    } else {
                        scores.put(target, 10);
                    }
                }
            }
        }

        // calculate visit score
        for (String visitor : visitors) {
            if (friendsOfUser.contains(visitor)) {
                continue;
            }
            if (scores.containsKey(visitor)) {
                scores.put(visitor, scores.get(visitor) + 1);
            } else {
                scores.put(visitor, 1);
            }
        }

        // sort the score list
        List<Map.Entry<String, Integer>> scoreList = new ArrayList<>(scores.entrySet());
        scoreList.sort((obj1, obj2) -> {
            if (obj1.getValue().equals(obj2.getValue())) {
                return obj1.getKey().compareTo(obj2.getKey());
            }
            return obj2.getValue().compareTo(obj1.getValue());
        });

        // return result list
        for (Map.Entry<String, Integer> score : scoreList) {
            answer.add(score.getKey());
            if (answer.size() >= 5) {
                break;
            }
        }
        return answer;
    }
}
