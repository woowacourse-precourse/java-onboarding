package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> friendMap = makeFriendMap(friends);
        Map<String, Integer> recommendScore = addScoreFriendKnow(user, friendMap);
        recommendScore = addScoreVisit(recommendScore, visitors);

        return recommendFriend(recommendScore);
    }

    public static Map<String, ArrayList<String>> makeFriendMap(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            ArrayList<String> AFriends = friendMap.getOrDefault(friendA, new ArrayList<>());
            AFriends.add(friendB);
            friendMap.put(friendA, AFriends);

            ArrayList<String> BFriends = friendMap.getOrDefault(friendB, new ArrayList<>());
            BFriends.add(friendA);
            friendMap.put(friendB, BFriends);
        }

        return friendMap;
    }

    public static Map<String, Integer> addScoreFriendKnow(String user, Map<String, ArrayList<String>> friendMap) {
        Map<String, Integer> recommendScore = new HashMap<>();

        for (String friend : friendMap.get(user)) {
            recommendScore.put(friend, -1);
            for (String friendKnow : friendMap.get(friend)) {
                if (friendKnow.equals(user)) continue;
                if (recommendScore.getOrDefault(friendKnow, 0) == -1) continue;
                recommendScore.put(friendKnow, recommendScore.getOrDefault(friendKnow, 0) + 10);
            }
        }

        return recommendScore;
    }

    public static Map<String, Integer> addScoreVisit(Map<String, Integer> recommendScore, List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendScore.getOrDefault(visitor, 0) == -1) continue;
            recommendScore.put(visitor, recommendScore.getOrDefault(visitor, 0) + 1);
        }
        return recommendScore;
    }

    public static List<String> recommendFriend(Map<String, Integer> recommendScore) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendScore.entrySet());
        entryList.sort(((o1, o2) -> recommendScore.get(o2.getKey()) - recommendScore.get(o1.getKey())));

        int count = 0;
        List<String> recommendList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            if (count == 5) break;
            if (entry.getValue() <= 0) break;
            recommendList.add(entry.getKey());
            count++;
        }

        return recommendList;
    }
}