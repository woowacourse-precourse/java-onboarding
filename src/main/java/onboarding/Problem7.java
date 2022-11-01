package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static int friendScore = 10;
    private static int visitScore = 1;

    public static boolean isUserFriends(
            HashMap<String, HashSet<String>> friendList, String user, String friend
    ) {
        return friendList.get(user).contains(friend);
    }

    public static HashMap<String, Integer> scoreVisitors(
            HashMap<String, HashSet<String>> friendList,
            HashMap<String, Integer> recommendedFriends,
            List<String> visitors,
            String user
    ) {
        for (String visitor: visitors) {
            if (!isUserFriends(friendList, user, visitor) && !Objects.equals(visitor, user)) {
                recommendedFriends.put(visitor, recommendedFriends.getOrDefault(visitor, visitScore) + visitScore);
            }
        }

        return recommendedFriends;
    }

    public static HashMap<String, HashSet<String>> createFriendList(List<List<String>> friends) {
        HashMap<String, HashSet<String>> friendListByUser = new HashMap<>();

        for (List<String> users: friends) {
            String user = users.get(0);
            String friend = users.get(1);

            if (friendListByUser.containsKey(user)) {
                friendListByUser.get(user).add(friend);
            } else {
                HashSet<String> friendList = new HashSet<>();
                friendList.add(friend);
                friendListByUser.put(user, friendList);
            }

            if (friendListByUser.containsKey(friend)) {
                friendListByUser.get(friend).add(user);
            } else {
                HashSet<String> friendList = new HashSet<>();
                friendList.add(user);
                friendListByUser.put(friend, friendList);
            }

        }

        return friendListByUser;
    }

    public static HashMap<String, Integer> findRecommendedFriend(
            HashMap<String, HashSet<String>> friendList, String user
    ) {
        HashMap<String, Integer> recommendedFriends = new HashMap<>();
        HashSet<String> friends = friendList.get(user);

        for (String friend: friends) {
            for (String recommendedFriend: friendList.get(friend)) {
                if (!isUserFriends(friendList, user, recommendedFriend) && !Objects.equals(recommendedFriend, user)) {
                    recommendedFriends.put(
                            recommendedFriend,
                            recommendedFriends.getOrDefault(recommendedFriend, friendScore) + friendScore
                    );
                }
            }
        }

        return recommendedFriends;
    }

    public static List<String> getRecommendedUsers(HashMap<String, Integer> recommendedFriends, int number) {
        return recommendedFriends
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(number)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> friendList = createFriendList(friends);
        HashMap<String, Integer> recommendedFriends =  findRecommendedFriend(friendList, user);
        List<String> answer = getRecommendedUsers(
                scoreVisitors(friendList, recommendedFriends, visitors, user), 5
        );

        return answer;
    }
}
