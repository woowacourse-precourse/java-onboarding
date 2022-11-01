package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem7 {

    private static Map<String, List<String>> userToFriendsMap;
    private static Map<String, Integer> userToScoreMap;
    private static List<String> friendList;
    private static final Integer friendScore = 10;
    private static final Integer visitScore = 1;

    public static List<String> solution(String user, List<List<String>> friends,
            List<String> visitors) {

        /* [요구] 사용자와 함께 아는 친구의 수 점수 계산 */
        makeUserToFriendsMap(friends);
        friendList = userToFriendsMap.get(user);
        calculateFriendScore(user);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void makeUserToFriendsMap(List<List<String>> friends) {
        userToFriendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            putFriend(friendA, friendB);
            putFriend(friendB, friendA);
        }
    }

    public static void putFriend(String friendA, String friendB) {
        if (userToFriendsMap.containsKey(friendA)) {
            userToFriendsMap.get(friendA).add(friendB);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(friendB);
            userToFriendsMap.put(friendA, newList);
        }
    }

    public static void calculateFriendScore(String user) {
        userToScoreMap = new HashMap<>();
        userToFriendsMap.forEach((s, friends) -> {
            int cnt = 0;
            if (friendList.contains(s) || s.equals(user)) {
                return;
            }
            for (String friend : friends) {
                if (friendList.contains(friend)) {
                    cnt++;
                }
            }
            userToScoreMap.put(s, cnt * friendScore);
        });
    }

}
