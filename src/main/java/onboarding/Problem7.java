package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Integer> userScore;
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userScore = new LinkedHashMap<>();
        userFriends = new HashSet<>();

        countFriends(user, friends);
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
    * 주어진 friends를 탐색하면서 각 사용자들의 친구 수를 계산
    * 이떄 주어진 user의 관계 정보라면 userFriends에 추가
    *
    * @return void
    * */
    private static void countFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String person1 = friend.get(0);
            String person2 = friend.get(1);

            if (user.equals(person1) || user.equals(person2)) {
                userFriends.add(person1);
                userFriends.add(person2);
                continue;
            }

            setUserScore(person1, 10);
            setUserScore(person2, 10);
        }
    }

    /*
    * 해당 사용자의 점수를 더한다.
    *
    * @return void
    * */
    private static void setUserScore(String person, int score) {
        userScore.put(person, userScore.getOrDefault(person, 0) + score);
    }

    /*
     * 주어진 visitors를 탐색하면서 각 사용자들의 방문 점수 계산
     *
     * @return void
     * */
    private static void countVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            setUserScore(visitor, 1);
        }
    }
}
