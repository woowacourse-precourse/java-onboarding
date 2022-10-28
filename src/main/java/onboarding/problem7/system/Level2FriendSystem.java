package onboarding.problem7.system;

import java.util.*;
import java.util.stream.Collectors;

public class Level2FriendSystem implements FriendSystem {
    private final Map<String, Set<String>> friendStatus = new HashMap<>();
    private Map<String, Integer> recommendUsers;

    @Override
    public void connectFriend(String userA, String userB) {
        Set<String> friendOfA = getFriendsOf(userA);
        Set<String> friendOfB = getFriendsOf(userB);

        friendOfA.add(userB);
        friendOfB.add(userA);

        friendStatus.put(userA, friendOfA);
        friendStatus.put(userB, friendOfB);
    }

    @Override
    public Set<String> getFriendsOf(String user) {
        return friendStatus.getOrDefault(user, new HashSet<>());
    }

    @Override
    public List<String> getRecommendFriendsOf(String user, List<String> visitors) {
        recommendUsers = new HashMap<>();
        Set<String> friendSet = getFriendsOf(user);

        // 친구의 친구인 사람
        for (String friend : friendSet) {
            updateRecommendUsersWithFriend(user, friend);
        }

        // 방문자
        for (String visitor : visitors) {
            updateRecommendUsersWithVisitor(user, visitor);
        }

        return convertRecommendUserSetToList();
    }

    private void updateRecommendUsersWithFriend(String user, String friend) {
        Set<String> friendSet = getFriendsOf(user);
        Set<String> friendsOfFriend = getFriendsOf(friend);
        for (String neighbor : friendsOfFriend) {
            if (friendSet.contains(neighbor) || neighbor.equals(user)) {
                continue;
            }
            int recommendScore = recommendUsers.getOrDefault(neighbor, 0) + 10;
            recommendUsers.put(neighbor, recommendScore);
        }
    }

    private void updateRecommendUsersWithVisitor(String user, String visitor) {
        Set<String> friendSet = getFriendsOf(user);
        if (friendSet.contains(visitor) || visitor.equals(user)) {
            return;
        }

        int recommendScore = recommendUsers.getOrDefault(visitor, 0) + 1;
        recommendUsers.put(visitor, recommendScore);
    }

    private List<String> convertRecommendUserSetToList() {
        return recommendUsers
                .keySet()
                .stream()
                .sorted((key1, key2) -> {
                    if (recommendUsers.get(key1) > recommendUsers.get(key2)) {
                        return -1;
                    } else if (Objects.equals(recommendUsers.get(key1), recommendUsers.get(key2))) {
                        return key1.compareTo(key2);
                    } else {
                        return 1;
                    }

                })
                .collect(Collectors.toList())
                .subList(0, Math.min(5, recommendUsers.size()));
    }

}
