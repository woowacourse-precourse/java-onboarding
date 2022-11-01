package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> relations = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();
        Set<String> newFriends = new HashSet<>();

        friendsReset(user, friends,  relations, newFriends);

        friendsScore(user, relations, newFriends, scores);

        visitorScore(user, relations, scores, visitors);

        List<Map.Entry<String, Integer>> scoreList = scores.entrySet().stream().collect(Collectors.toList());
        scoreList.sort((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        
        int cnt = 0;
        for (Map.Entry<String, Integer> friend : scoreList) {
            if (friend.getValue() == 0 || cnt == 5) break;
            answer.add(friend.getKey());
            cnt++;
        }

        return answer;
    }

    public static void friendsReset(String user, List<List<String>> friends, Map<String, Set<String>> relations, Set<String> newFriends) {
        for (List<String> friend : friends) {
            String from = friend.get(0);
            String to = friend.get(1);

            if (relations.containsKey(from)) {
                relations.get(from).add(to);
            } else {
                relations.put(from, new HashSet<>(Arrays.asList(to)));
            }
            if (relations.containsKey(to)) {
                relations.get(to).add(from);
            } else {
                relations.put(to, new HashSet<>(Arrays.asList(from)));
            }

            if (!from.equals(user) && !to.equals(user)) {
                newFriends.add(from);
                newFriends.add(to);
            }
        }
    }

    public static void friendsScore(String user, Map<String, Set<String>> relations, Set<String> newFriends, Map<String, Integer> scores) {
        List<String> myFriends = new ArrayList<>(relations.get(user));
        for (String friend : myFriends) {
            newFriends.remove(friend);
        }
        for (String friend : newFriends) {
            scores.put(friend, 10);
        }
    }

    public static void visitorScore(String user, Map<String, Set<String>> relations, Map<String, Integer> scores, List<String> visitors)
    {
        for (String visitor : visitors) {
            if (relations.get(user).contains(visitor)) continue;

            if (scores.containsKey(visitor)) {
                scores.put(visitor, scores.get(visitor) + 1);
            } else {
                scores.put(visitor, 1);
            }
        }
    }
}
