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

    public void addScore(int score) {
        this.score += score;
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

        List<RecommendedFriend> recommendedFriendList = createRecommendedFriends(user, userFriendList, friends);
        recommendedFriendList = visitorScore(recommendedFriendList, visitors, userFriendList);

        return null;
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

    private static List<RecommendedFriend> createRecommendedFriends(String user, List<String> userFriends, List<List<String>> friends) {
        List<RecommendedFriend> result = new ArrayList<>();
        for (String userFriend : userFriends) {
            for (List<String> friend : friends) {
                if (isFriend(userFriend, friend)) {
                    String name = findFriendByName(userFriend, friend);
                    if (isNotUser(user, name)) {
                        result.add(new RecommendedFriend(name));
                    }
                }
            }
        }
        return result;
    }

    private static List<RecommendedFriend> visitorScore(List<RecommendedFriend> recommendedFriendList, List<String> visitors, List<String> userFriendList) {
        List<RecommendedFriend> result = new ArrayList<>();
        for (String visitor : visitors) {
            if (!userFriendList.contains(visitor)) {
                RecommendedFriend findRecommendedFriend = findRecommendedFriendByName(visitor, recommendedFriendList);
                findRecommendedFriend.addScore(1);
                result.add(findRecommendedFriend);
            }
        }
        return result;
    }

    private static RecommendedFriend findRecommendedFriendByName(String name, List<RecommendedFriend> recommendedFriendList) {
        for (RecommendedFriend recommendedFriend : recommendedFriendList) {
            if (recommendedFriend.getName().equals(name)) {
                return recommendedFriend;
            }
        }
        return new RecommendedFriend(name);
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
