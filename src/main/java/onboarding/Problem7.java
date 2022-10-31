package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Set<String>> userFriendsMap;
    static Map<String, Integer> userScore;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriendsMap = new HashMap<>();
        userScore = new HashMap<>();

        userFriendsMap.put(user, new HashSet<>());
        setUserFriendsMap(friends);
        countVisitors(visitors);

        Set<String> userFriends = userFriendsMap.get(user);
        computeScoreOfFriends(user, userFriends);

        return userScore.keySet().stream()
                .filter(o -> !userFriends.contains(o))
                .sorted((o1, o2) -> {
                    if (userScore.get(o1).equals(userScore.get(o2))) {
                        return o1.compareTo(o2);
                    }
                    return Integer.compare(userScore.get(o2), userScore.get(o1));
                })
                .limit(5)
                .collect(Collectors.toList());
    }

    /*
    * friends를 탐색하면서 사용자들의 친구 관계를 저장하는 기능
    *
    * @return void
    * */
    private static void setUserFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String person1 = friend.get(0);
            String person2 = friend.get(1);

            setUserFriend(person1, person2);
            setUserFriend(person2, person1);
        }
    }

    /*
    * 두 사용자 간 친구 관계를 설정
    *
    * @return void
    * */
    private static void setUserFriend(String person1, String person2) {
        Set<String> friendSet = userFriendsMap.getOrDefault(person1, new HashSet<>());
        friendSet.add(person2);
        userFriendsMap.put(person1, friendSet);
    }

    /*
    * 해당 사용자의 방문 점수를 더한다.
    *
    * @return void
    * */
    private static void setUserScore(String person) {
        userScore.put(person, userScore.getOrDefault(person, 0) + 1);
    }

    /*
     * 주어진 visitors를 탐색하면서 각 사용자들의 방문 점수 계산
     *
     * @return void
     * */
    private static void countVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            setUserScore(visitor);
        }
    }

    /*
    * user의 친구의 친구들 중, user를 제외한 사용자들의 점수를 계산
    *
    * @return void
    * */
    private static void computeScoreOfFriends(String user, Set<String> userFriends) {
        for (String userFriend : userFriends) {
            Set<String> friendsOfFriend = userFriendsMap.get(userFriend);

            getAnonymousScore(user, friendsOfFriend);
        }
    }

    /*
    * 주어진 사용자 Set에 user가 아니고, user와 친구도 아닌 사용자들의 점수를 계산
    *
    * @return void
    * */
    private static void getAnonymousScore(String user, Set<String> friendsOfFriend) {
        for (String friend : friendsOfFriend) {
            if (friend.equals(user) || userFriendsMap.get(friend).contains(user)) {
                continue;
            }
            userScore.put(friend, userFriendsMap.get(friend).size() * 10 + userScore.getOrDefault(friend, 0));
        }
    }
}
