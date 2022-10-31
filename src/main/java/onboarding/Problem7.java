package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> userFriends;
        Map<String, Integer> scored = new HashMap<>();
        List<Map.Entry<String, Integer>> recommendList;

        userFriends = findUserFriends(user, friends);
        scoreFriends(user, friends, userFriends, scored);
        scoreVisitors(visitors, userFriends, scored);

        recommendList = new ArrayList<>(scored.entrySet());
        recommendList.sort(Map.Entry.comparingByKey());
        recommendList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < recommendList.size(); i++) {
            if (answer.size() > 5) {
                break;
            }
            answer.add(recommendList.get(i).getKey());

        }
        return answer;
    }

    public static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriends = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    userFriends.add(friend.get(1));
                    continue;
                }
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

    public static void scoreFriends(String user, List<List<String>> friends,
                                                    Set<String> userFriends, Map<String, Integer> map) {
        String name;
        int score;

        for (List<String> friend : friends) {
            name = friend.get(1);
            score = 10;
            if (userFriends.contains(friend.get(0)) && !friend.get(1).equals(user)) {
                if (!userFriends.contains(friend.get(1))) {
                    if (map.containsKey(name)) {
                        score += map.get(name);
                    }
                    map.put(name, score);
                }
            } else if (userFriends.contains(friend.get(1)) && !friend.get(0).equals(user)) {
                if (!userFriends.contains(friend.get(0))) {
                    name = friend.get(0);
                    if (map.containsKey(name)) {
                        score += map.get(name);
                    }
                    map.put(name, score);
                }
            }
        }
    }

    public static void scoreVisitors(List<String> visitors, Set<String> userFriends, Map<String, Integer> map) {
        int score;
        for (String visitor : visitors) {
            score = 1;
            if (!userFriends.contains(visitor)) {
                if (map.containsKey(visitor)) {
                    score += map.get(visitor);
                }
                map.put(visitor, score);
            }
        }
    }





}
