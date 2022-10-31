package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Set<String>> userFriendsMap;
    static Map<String, Integer> visitorsScoreMap;
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriendsMap = new HashMap<>();
        visitorsScoreMap = new LinkedHashMap<>();
        userFriends = new HashSet<>();

        userFriendsMap.put(user, new HashSet<>());
        setUserFriendsMap(friends);
        countVisitors(visitors);

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
        visitorsScoreMap.put(person, visitorsScoreMap.getOrDefault(person, 0) + 1);
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
}
