package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> userScore;
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userScore = new HashMap<>();
        userFriends = new HashSet<>();

        List<String> answer = Collections.emptyList();
        return answer;
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

            if (user == person1 || user == person2) {
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
     * 이떄 주어진 user의 친구는 제외
     *
     * @return void
     * */
    private static void countVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }

            setUserScore(visitor, 1);
        }
    }
}
