package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) { // MST, BFS 써보고 싶은데 내 개념이 모호해서..  6번과 유사하게 접근해보기.
        Set<String> userFriend = new HashSet<>(); // user와 직접 친구, 간접친구 구분 후 부여받을 점수 고려
        List<List<String>> knownFriend = new ArrayList<>();
        Map<String, Integer> friendScore = new HashMap<>();
    }
}
