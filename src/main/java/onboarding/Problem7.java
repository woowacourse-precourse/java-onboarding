package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class RecommendedFriend implements Comparable<RecommendedFriend> {

    private String name;
    private int score;

    public RecommendedFriend(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(RecommendedFriend other) {
        if (this.score < other.score) {
            return -1;
        } else if (this.score == other.score) {
            if (this.name.compareTo(other.name) > 0) {
                return -1;
            }
        }
        return 1;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendList = findFriendListByUser(user, friends);
        Map<String, Integer> recommendedFriends = createRecommendedFriends(user ,userFriendList, friends);
        recommendedFriends = visitorScore(recommendedFriends, visitors, userFriendList);

        return findTop5ScoreUser(recommendedFriends);
    }

    private static List<String> findFriendListByUser(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (isFriend(user, friend)) {
                String friendName = findFriendByName(user, friend);
                friendList.add(friendName);
            }
        }
        return friendList;
    }

    private static Map<String, Integer> createRecommendedFriends(String user, List<String> userFriends, List<List<String>> friends) {
        Map<String, Integer> result = new HashMap<>();
        for (String userFriend : userFriends) {
            for (List<String> friend : friends) {
                if (isFriend(userFriend, friend)) {
                    String name = findFriendByName(userFriend, friend);
                    if (isNotUser(user, name)) {
                        Integer score = result.getOrDefault(name, 0);
                        result.put(name, score + 10);
                    }
                }
            }
        }
        return result;
    }

    private static Map<String, Integer> visitorScore(Map<String, Integer> recommendedFriendMap, List<String> visitors, List<String> userFriendList) {
        for (String visitor : visitors) {
            if (!userFriendList.contains(visitor)) {
                Integer score = recommendedFriendMap.getOrDefault(visitor, 0);
                recommendedFriendMap.put(visitor, score + 1);
            }
        }
        return recommendedFriendMap;
    }

    private static List<String> findTop5ScoreUser(Map<String, Integer> recommendedFriendMap) {
        List<Map.Entry<String, Integer>> collect = recommendedFriendMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : collect) {
            result.add(entry.getKey());
            if (result.size() == 5) {
                break;
            }
        }
        return result;
    }

    private static boolean isFriend(String target, List<String> friend) {
        return nameEq(target, friend.get(0)) || nameEq(target, friend.get(1));
    }

    private static String findFriendByName(String target, List<String> friend) {
        if (nameEq(target, friend.get(0))) {
            return friend.get(1);
        } else {
            return friend.get(0);
        }
    }

    private static boolean nameEq(String user, String target) {
        return user.equals(target);
    }

    private static boolean isNotUser(String user, String target) {
        return !user.equals(target);
    }
}
