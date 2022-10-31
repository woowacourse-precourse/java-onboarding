package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Problem: 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
 */
public class Problem7 {
    private static final int POINT_OF_VISITOR = 1;             // 방문자 추천 점수
    private static final int POINT_OF_FRIEND_OF_FRIEND = 10;   // 친구의 친구 추천 점수

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendMap = getFriendMap(friends);
        Map<String, Integer> pointOfFriend = getPointOfFriend(user, visitors, friendMap);
        return getAnswer(pointOfFriend);
    }

    private static Map<String, List<String>> getFriendMap(List<List<String>> friends) {
        // 1. 이름을 key, 친구의 이름 List value로 갖는 Map을 만든다.
        Map<String, List<String>> friendMap = new HashMap<>();
        // 2. friends의 0, 1 인덱스를 각각 key로 두고, 서로를 value에 추가한다.
        for(List<String> friend : friends) {
            putFriendAtMap(friendMap, friend, 0, 1);
            putFriendAtMap(friendMap, friend, 1, 0);
        }
        return friendMap;
    }

    private static Map<String, Integer> getPointOfFriend(String user, List<String> visitors, Map<String, List<String>> friendMap) {
        // 3. Name, Point를 각각 key, value로 갖는 Map을 만든다.
        Map<String, Integer> pointOfFriend = new HashMap<>();
        List<String> friendsOfUser = friendMap.getOrDefault(user, new ArrayList<>());
        countFriendOfFriendPoint(user, friendMap, pointOfFriend, friendsOfUser);
        countVisitorPoint(visitors, pointOfFriend, friendsOfUser);
        return pointOfFriend;
    }

    private static void putFriendAtMap(Map<String, List<String>> friendMap, List<String> friend, int indexOfUser, int indexOfFriend) {
        if (friendMap.containsKey(friend.get(indexOfUser))) {
            List<String> friendList = friendMap.get(friend.get(indexOfUser));
            friendList.add(friend.get(indexOfFriend));
            friendMap.replace(friend.get(indexOfUser), friendList);
        } else {
            List<String> friendList = new ArrayList<>();
            friendList.add(friend.get(indexOfFriend));
            friendMap.put(friend.get(indexOfUser), friendList);
        }
    }

    private static void countFriendOfFriendPoint(String user, Map<String, List<String>> friendMap, Map<String, Integer> pointOfFriend, List<String> friendsOfUser) {
        for (String friend : friendsOfUser) {
            List<String> friendsOfFriend = friendMap.get(friend);
            for (String friendOfFriend : friendsOfFriend) {
                if (!friendsOfUser.contains(friendOfFriend) && !friendOfFriend.equals(user)) {  // 4 - 1, User 자신과, 이미 친구인 사람은 제외 한다.
                    putPointAtMap(pointOfFriend, friendOfFriend, POINT_OF_FRIEND_OF_FRIEND);
                }
            }
        }
    }

    private static void countVisitorPoint(List<String> visitors, Map<String, Integer> pointOfFriend, List<String> friendsOfUser) {
        // 6. visitors를 참고하여, 해당하는 사람에게 점수를 1점씩 추가한다.
        for (String visitor : visitors) {
            if (!friendsOfUser.contains(visitor)) {
                putPointAtMap(pointOfFriend, visitor, POINT_OF_VISITOR);
            }
        }
    }

    private static void putPointAtMap(Map<String, Integer> pointOfFriend, String visitor, int point) {
        if (pointOfFriend.containsKey(visitor)) {
            pointOfFriend.replace(visitor, pointOfFriend.get(visitor) + point);
        } else {
            pointOfFriend.put(visitor, point);
        }
    }

    private static List<String> getAnswer(Map<String, Integer> pointOfFriend) {
        return pointOfFriend.keySet().stream()
                .sorted(((o1, o2) -> {      // 7. 점수 순서, 동점인 경우, 알파벳 순서로 정렬한다.
                    return compareStringByInteger(pointOfFriend, o1, o2);
                }))
                .limit(5)       // 8. 최대 상위 5명까지의 이름을 List로 반환한다.
                .collect(Collectors.toList());
    }

    private static int compareStringByInteger(Map<String, Integer> pointOfFriend, String o1, String o2) {
        int compare = pointOfFriend.get(o2) - pointOfFriend.get(o1);
        if (compare == 0) {
            return o1.compareTo(o2);
        }
        return compare;
    }
}
