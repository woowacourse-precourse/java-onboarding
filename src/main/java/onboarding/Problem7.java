package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Problem: 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
 */
public class Problem7 {
    /**
     * @Method: recommendFriends
     * 1. 이름을 key, 친구의 이름 List value로 갖는 Map을 만든다.
     * 2. friends의 0, 1 인덱스를 각각 key로 두고, 서로를 value에 추가한다.
     * 3. Name, Point를 각각 key, value로 갖는 Map을 만든다.
     * 4. user의 친구 List에 있는 사람들의 친구(친구의 친구)의 이름을 key에 추가하고, 점수를 10점씩 추가한다.
     * 4 - 1, User 자신과, 이미 친구인 사람은 제외 한다.
     * 5. visitors를 참고하여, 해당하는 사람에게 점수를 1점씩 추가한다.
     * 6. 점수 순서, 동점인 경우, 알파벳 순서로 정렬한다.
     * 7. 최대 상위 5명까지의 이름을 List로 반환한다.
     */

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 1. 이름을 key, 친구의 이름 List value로 갖는 Map을 만든다.
        Map<String, List<String>> friendMap = new HashMap<>();
        // 2. friends의 0, 1 인덱스를 각각 key로 두고, 서로를 value에 추가한다.
        for(List<String> friend : friends) {
            if (friendMap.containsKey(friend.get(0))) {
                List<String> friendList = friendMap.get(friend.get(0));
                friendList.add(friend.get(1));
                friendMap.replace(friend.get(0), friendList);
            } else {
                List<String> friendList = new ArrayList<>();
                friendList.add(friend.get(1));
                friendMap.put(friend.get(0), friendList);
            }

            if (friendMap.containsKey(friend.get(1))) {
                List<String> friendList = friendMap.get(friend.get(1));
                friendList.add(friend.get(0));
                friendMap.replace(friend.get(1), friendList);
            } else {
                List<String> friendList = new ArrayList<>();
                friendList.add(friend.get(0));
                friendMap.put(friend.get(1), friendList);
            }
        }



        Map<String, Integer> pointOfFriend = new HashMap<>(); // 3. Name, Point를 각각 key, value로 갖는 Map을 만든다.

        // 4. user의 친구 List에 있는 사람들의 친구(친구의 친구)의 이름을 key에 추가하고, 점수를 10점씩 추가한다.
        List<String> friendsOfUser = friendMap.getOrDefault(user, new ArrayList<>());
        for (String friend : friendsOfUser) {
            List<String> friendsOfFriend = friendMap.get(friend);
            for (String friendOfFriend : friendsOfFriend) {
                if (!friendsOfUser.contains(friendOfFriend) && !friendOfFriend.equals(user)) {  // 4 - 1, User 자신과, 이미 친구인 사람은 제외 한다.
                    if (pointOfFriend.containsKey(friendOfFriend)) {
                        pointOfFriend.replace(friendOfFriend, pointOfFriend.get(friendOfFriend) + 10);
                    } else {
                        pointOfFriend.put(friendOfFriend, 10);
                    }
                }
            }
        }


        // 6. visitors를 참고하여, 해당하는 사람에게 점수를 1점씩 추가한다.
        for (String visitor : visitors) {
            if (!friendsOfUser.contains(visitor)) {
                if (pointOfFriend.containsKey(visitor)) {
                    pointOfFriend.replace(visitor, pointOfFriend.get(visitor) + 1);
                } else {
                    pointOfFriend.put(visitor, 1);
                }
            }
        }

        List<String> answer = pointOfFriend.keySet().stream()
                .sorted(((o1, o2) -> {      // 7. 점수 순서, 동점인 경우, 알파벳 순서로 정렬한다.
                    int compare = pointOfFriend.get(o2) - pointOfFriend.get(o1);
                    if (compare == 0) {
                        return o1.compareTo(o2);
                    }
                    return compare;
                }))
                .limit(5)       // 8. 최대 상위 5명까지의 이름을 List로 반환한다.
                .collect(Collectors.toList());

        return answer;
    }
}
