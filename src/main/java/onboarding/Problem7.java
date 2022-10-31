package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> userScore;
    static Set<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userScore = new LinkedHashMap<>();
        userFriends = new HashSet<>();

        countFriends(user, friends);
        countVisitors(visitors);

        List<Map.Entry<String, Integer>> userScoreList = sortUserFriends(removeUserFriends());

        return makeKeyList(userScoreList);
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

    /*
    * Map에서 user의 친구를 제거
    *
    * @return List<Map.Entry<String, Integer>>
    * */
    private static List<Map.Entry<String, Integer>> removeUserFriends() {
        List<Map.Entry<String, Integer>> userScoreList = new LinkedList<>(userScore.entrySet());
        userScoreList.removeIf(entry -> userFriends.contains(entry.getKey()));
        return userScoreList;
    }

    /*
    * Map을 value을 기준으로 내림차순 정렬
    * 이때 value가 같다면 이름순 정렬
    *
    * @return List<Map.Entry<String, Integer>>
    * */
    private static List<Map.Entry<String, Integer>> sortUserFriends(List<Map.Entry<String, Integer>> userScoreList) {
        userScoreList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        return userScoreList;
    }


    /*
    * List<Map.Entry<String, Integer>>의 각 Key를 List로 만들어 반환
    *
    * @return List<String>
    * */
    private static List<String> makeKeyList(List<Map.Entry<String, Integer>> userScoreList) {
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> userScore : userScoreList) {
            answer.add(userScore.getKey());
        }
        return answer;
    }
}
