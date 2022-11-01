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

    private static final Comparator<Map.Entry<String, Integer>> valueComparator =
            Map.Entry.comparingByValue(Comparator.reverseOrder());
    private static final Comparator<Map.Entry<String, Integer>> keyComparator =
            Map.Entry.comparingByKey();

    public static List<String> solution(String user, List<List<String>> friends,
            List<String> visitors) {

        /* [요구] 사용자와 함께 아는 친구의 수 점수 계산 */
        makeUserToFriendsMap(friends);
        friendList = userToFriendsMap.get(user);
        calculateFriendScore(user);

        /* [요구] 사용자의 타임 라인에 방문한 횟수 점수 계산 */
        calculateVisitScore(visitors);

        /* [요구] 점수가 가장 높은 순으로 정렬하여 최대 5명 리턴 */
        return userToScoreMap.entrySet().stream()
                .sorted(valueComparator.thenComparing(keyComparator))
                .limit(5)
                .map(Entry::getKey)
                .collect(Collectors.toList());
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

    public static void calculateVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (friendList.contains(visitor)) { // 사용자와 친구인 유저 제외
                continue;
            }
            if (userToScoreMap.containsKey(visitor)) {
                userToScoreMap.put(visitor, userToScoreMap.get(visitor) + visitScore);
            } else {
                userToScoreMap.put(visitor, visitScore);
            }
        }
    }
}
