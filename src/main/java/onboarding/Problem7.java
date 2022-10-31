package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static HashMap<String, Integer> score;

    public static void Hashing(String user, List<List<String>> friends, List<String> visitors) {
        score.put(user, 0);
        for (List<String> i : friends) {
            score.put(i.get(0), 0);
            score.put(i.get(1), 0);
        }
        for (String i : visitors) {
            score.put(i, 0);
        }
    }

    public static void scoringWithFriends(String user, List<List<String>> friends) {
        // user의 친구들을 모두 모음.
        HashSet<String> isFriendOfUser = new HashSet<>();
        for (List<String> i : friends) {
            if (i.get(0) == user) isFriendOfUser.add(i.get(1));
            if (i.get(1) == user) isFriendOfUser.add(i.get(0));
        }

        // 점수 계산
        for (List<String> i : friends) {
            if (isFriendOfUser.contains(i.get(0))) {
                score.put(i.get(1), score.get(i.get(1)) + 10);
            }
            if (isFriendOfUser.contains(i.get(1))) {
                score.put(i.get(0), score.get(i.get(0)) + 10);
            }
        }
    }

    public static void scoringWithVisits(List<String> visitors) {
        for (String i : visitors) {
            score.put(i, score.get(i) + 1);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // 친구들의 이름과 점수를 map으로 저장
        Hashing(user, friends, visitors);

        // 사용자와 함께 아는 친구의 수에 따른 점수 계산
        scoringWithFriends(user, friends);

        // 방문 횟수에 따른 점수 계산
        scoringWithVisits(visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
