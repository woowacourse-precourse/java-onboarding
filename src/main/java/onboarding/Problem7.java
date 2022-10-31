package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        final int friends_to_friends_count = 10;
        final int visitors_count = 1;
        
        HashMap<String, Integer> friendRecommendationMap = new HashMap<>();

        List<String> usersFriends = new ArrayList<>(findUserFriend(friends, user));
        List<String> usersFriendsToFriends = new ArrayList<>(findUserFriendToFriend(friends, usersFriends, user));
        countFriendsShip(friendRecommendationMap, usersFriendsToFriends, friends_to_friends_count);
        countFriendsShip(friendRecommendationMap, visitors, visitors_count);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static HashSet<String> findUserFriend(List<List<String>> friends, String user) {
        HashSet<String> usersFriends = new HashSet<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                usersFriends.add(friend.get(0));
                usersFriends.add(friend.get(1));
            }
        }

        usersFriends.remove(user);
        return usersFriends;
    }

    public static HashSet<String> findUserFriendToFriend(List<List<String>> friends, List<String> usersFriends, String user) {
        HashSet<String> usersFriendToFriends = new HashSet<>();

        for (String usersFriend : usersFriends) {
            usersFriendToFriends.addAll(findUserFriend(friends, usersFriend));
        }

        usersFriendToFriends.remove(user);
        return usersFriendToFriends;
    }

    public static void countFriendsShip(HashMap<String, Integer> friendRecommendationMap, List<String> friendsToFriends, int count) {
        for (String name : friendsToFriends) {
            if (friendRecommendationMap.containsKey(name)) {
                friendRecommendationMap.put(name, friendRecommendationMap.get(name) + count);
                continue;
            }
            friendRecommendationMap.put(name, count);
        }
    }
}
