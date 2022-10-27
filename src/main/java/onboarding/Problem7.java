package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> relations = new HashMap<>();
        /*사용자와 친구들 관계 구현*/
        userAndFriendRelations(friends, relations);
        /*사용자와 함께 아는 친구의 수 점수 구하기*/
        Map<String, Integer> scores = saveScoreOfFriend(user, relations);
        /*사용자의 타임 라인에 방문한 횟수 점수 구하기*/

        /*점수가 가장 높은 순으로 정렬, 점수가 같은 경우는 이름순으로 정렬*/

        return answer;
    }

    private static void userAndFriendRelations(List<List<String>> friends, Map<String, List<String>> relations) {
        for (List<String> friend : friends) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);
            if (!relations.containsKey(friendA)) {
                relations.put(friendA, new ArrayList<>());
            }
            if (!relations.containsKey(friendB)) {
                relations.put(friendB, new ArrayList<>());
            }
            relations.get(friendA).add(friendB);
            relations.get(friendB).add(friendA);
        }
    }

    private static Map<String, Integer> saveScoreOfFriend(String user, Map<String, List<String>> relations) {
        Map<String, Integer> scores = new HashMap<>();
        for (String friendRecommend : relations.get(user)) {
            List<String> recommend = relations.get(friendRecommend);
            for (String friend : recommend) {
                if (scores.containsKey(friend)) {
                    scores.put(friend, scores.get(friend) + 10);
                    continue;
                }
                scores.put(friend, 0);
            }
        }
        return scores;
    }
}
