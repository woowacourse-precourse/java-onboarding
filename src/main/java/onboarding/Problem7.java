package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) { // MST, BFS 써보고 싶은데 내 개념이 모호해서..  6번과 유사하게 접근해보기.
        Set<String> userFriend = new HashSet<>(); // user와 직접 친구, 간접친구 구분 후 부여받을 점수 고려
        List<List<String>> knownFriend = new ArrayList<>();
        Map<String, Integer> Score = new HashMap<>();

        for (List<String> friend : friends) {  // 전체 배열을 돌면서 직접친구 추출, 그 외는 간접친구로 취급
            if (friend.get(0).equals((user)))
                userFriend.add(friend.get(1));
            else if (friend.get(1).equals(user))
                userFriend.add(friend.get(0));
            else
                knownFriend.add(friend);
        }
        for (List<String> friendScore : knownFriend) {
            String friend1 = friendScore.get(0);
            String friend2 = friendScore.get(1);

            if (userFriend.contains(friend1) && !userFriend.contains(friend2)) // 간접친구 조건, 해당하면 10점 획득
                Score.put(friend2, Score.getOrDefault(friend2, 0) + 10);
            else if (userFriend.contains(friend1) && !userFriend.contains((friend1)))
                Score.put(friend1, Score.getOrDefault(friend1, 0) + 10);
        }
        for (String visit : visitors) { //방문자 판별 조건 - 직접친구 아니고, user 본인 아닌데 접속 시 1점
            if (!userFriend.contains(visit) && !visit.equals(user))
                Score.put(visit, Score.getOrDefault(visit, 0) + 1);
        }
    }
}
