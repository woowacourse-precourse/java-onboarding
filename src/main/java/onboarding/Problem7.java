package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> map;
    static List<String> userFriends;
    static Map<String, Integer> recommendScore;
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        map = getMap(friends);
        userFriends = map.get(user);
        recommendScore = new HashMap<>();

        scoreFriendsKnowTogetherCount(user);
        scoreTimeLineVisitCount(visitors);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(recommendScore.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : list) {
            if(result.size() == 5) {
                break;
            }
            if(recommendScore.get(entry.getKey()) == 0) {
                break;
            }
            result.add(entry.getKey());
        }

        return result;
    }

    private static void scoreTimeLineVisitCount(List<String> visitors) {
        for(String visitor : visitors) {
            if(userFriends.contains(visitor)) {
                continue;
            }

            if(recommendScore.containsKey(visitor)) {
                int score = recommendScore.get(visitor) + 1;
                recommendScore.put(visitor, score);
            } else {
                recommendScore.put(visitor, 1);
            }
        }
    }

    private static void scoreFriendsKnowTogetherCount(String user) {
        for(String key : map.keySet()) {
            if(key.equals(user)) {
                continue;
            }
            recommendScore.put(key, 0);

            List<String> friendList = map.get(key);
            for(String friend : friendList) {
                if(userFriends.contains(friend)) {
                    int score = recommendScore.get(key) + 10;
                    recommendScore.put(key, score);
                }
            }
        }
    }

    private static Map<String, List<String>> getMap(List<List<String>> friends) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1, list2;

        for(List<String> friend : friends) {
            if(map.containsKey(friend.get(0))) {
                list1 = map.get(friend.get(0));
            } else {
                list1 = new ArrayList<>();
            }
            list1.add(friend.get(1));
            map.put(friend.get(0), list1);

            if(map.containsKey(friend.get(1))) {
                list2 = map.get(friend.get(1));
            } else {
                list2 = new ArrayList<>();
            }
            list2.add(friend.get(0));
            map.put(friend.get(1), list2);
        }
        return map;
    }
}
