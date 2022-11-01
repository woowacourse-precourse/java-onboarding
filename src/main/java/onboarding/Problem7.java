package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int bothKnownScore = 10;
    private static final int visitScore = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Map<String, List<String>> getFriendList(List<List<String>> friends) {
        Map<String, List<String>> friendMap = new HashMap<>();

        String friend1, friend2;
        List<String> friend1Value;
        List<String> friend2Value;

        for (List<String> friend : friends) {
            friend1 = friend.get(0);
            friend2 = friend.get(1);

            friend1Value = friendMap.getOrDefault(friend1, new ArrayList<>());
            friend2Value = friendMap.getOrDefault(friend2, new ArrayList<>());

            friend1Value.add(friend2);
            friend2Value.add(friend1);

            friendMap.put(friend1, friend1Value);
            friendMap.put(friend2, friend2Value);
        }

        return friendMap;
    }

    private static Map<String, Integer> getBothKnownCount(String user, Map<String, List<String>> friendMap) {
        List<String> userFriends = friendMap.getOrDefault(user, new ArrayList<>());
        List<String> friendList;
        Integer count;

        Map<String, Integer> bothKnownCount = new HashMap<>();

        for (String userFriend : userFriends) {
            friendList = friendMap.getOrDefault(userFriend, new ArrayList<>());

            for (String friend : friendList) {
                if (friend.equals(user) || userFriends.contains(friend)) {
                    continue;
                }

                count = bothKnownCount.getOrDefault(friend, 0);
                bothKnownCount.put(friend, count + 1);
            }
        }

        return bothKnownCount;
    }

    private static Map<String, Integer> getVisitCount(List<String> visitors, String user, Map<String, List<String>> friendMap) {
        List<String> userFriends = friendMap.getOrDefault(user, new ArrayList<>());
        Integer count;

        Map<String, Integer> visitCount = new HashMap<>();

        for (String visitor : visitors) {
            if (visitor.equals(user) || userFriends.contains(visitor)) {
                continue;
            }

            count = visitCount.getOrDefault(visitor, 0);
            visitCount.put(visitor, count + 1);
        }

        return visitCount;
    }
    private static Map<String, Integer> getTotalScore(Map<String, Integer> bothKnownCount, Map<String, Integer> visitCount) {
        Map<String, Integer> totalCount = new HashMap<>();

        for (String bothKnown : bothKnownCount.keySet()) {
            totalCount.put(bothKnown, bothKnownCount.get(bothKnown) * bothKnownScore);
        }

        for (String visit : visitCount.keySet()) {
            totalCount.put(visit, totalCount.getOrDefault(visit, 0) + visitCount.get(visit) * visitScore);
        }

        return totalCount;
    }

    private static List<String> getResult(Map<String, Integer> totalScore) {
        List<String> keySetList = new ArrayList<>(totalScore.keySet());

        keySetList.sort((o1, o2) -> {
            if (totalScore.get(o1) < totalScore.get(o2)) {
                return 1;
            } else if (totalScore.get(o1) > totalScore.get(o2)) {
                return -1;
            }

            return o1.compareTo(o2);
        });

        return keySetList.stream().limit(5).collect(Collectors.toList());
    }
}