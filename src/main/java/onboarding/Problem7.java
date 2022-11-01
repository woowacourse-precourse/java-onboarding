package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (isUserException(user) || isFriendsException(friends) || isVisitorsException(visitors)) {
            throw new RuntimeException("올바르지 않은 인자입니다.");
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Boolean isUserException(String user) {
        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) < 'a' || user.charAt(1) > 'z') return true;
        }
        return user.length() < 1 || user.length() > 30;
    }

    private static Boolean isFriendsException(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) return true;
        return friends.stream()
                .anyMatch(friend -> (friend.size() != 2)
                        || (friend.stream().anyMatch(f -> (f.length() < 1 || f.length() > 30))));
    }

    private static Boolean isVisitorsException(List<String> visitors) {
        return visitors.size() < 0 || visitors.size() > 10000;
    }

    private static Map<String, List<String>> getFriendsMap(List<List<String>> friends,
                                                           List<String> userFriends,
                                                           String user
    ) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        for (List<String> friendShip : friends) {
            if (friendShip.contains(user)) {
                userFriends.add(friendShip.get(0).equals(user)
                        ? friendShip.get(0)
                        : friendShip.get(1));
                continue;
            }
            //아직 등록하지 않은 친구는 등록 후 저장
            friendsMap.computeIfAbsent(friendShip.get(0), k -> new ArrayList<String>());
            friendsMap.get(friendShip.get(0)).add(friendShip.get(1));

            friendsMap.computeIfAbsent(friendShip.get(1), k -> new ArrayList<String>());
            friendsMap.get(friendShip.get(1)).add(friendShip.get(0));
        }

        return friendsMap;
    }

    private static Map<String, Integer> getScoreMap(Map<String, List<String>> friendsMap,
                                                    List<String> userFriends
    ) {
        Map<String, Integer> scoreMap = new HashMap<>();

        for (String userFriend : userFriends) {
            List<String> friends = friendsMap.get(userFriend);
            for (String friend : friends) {
                scoreMap.computeIfAbsent(friend, k -> 0);
                scoreMap.put(friend, scoreMap.get(friend) + 10);
            }
        }

        return scoreMap;
    }
}
