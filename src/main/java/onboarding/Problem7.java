package onboarding;

import java.util.*;
/*
* 기능목록
*
* 1. 사용자와 친구인 사람 목록 작성
* 2. 친구와 아는사람 점수부여 기능
* 3. 방문자 점수부여
* 4. 정렬기능
* */

public class Problem7 {

    static HashMap<String, Set<String>> friendsHashMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void friendList(String user, List<List<String>> friends) {
        for (List<String> f : friends) {
            if (!f.get(0).equals(user)) points.put(f.get(0), 0);
            if (!f.get(1).equals(user)) points.put(f.get(1), 0);
            if (!friendsHashMap.containsKey(f.get(0))) {
                friendsHashMap.put(f.get(0), new HashSet<>());
            }
            if (!friendsHashMap.containsKey(f.get(1))) {
                friendsHashMap.put(f.get(1), new HashSet<>());
            }
            friendsHashMap.get(f.get(0)).add(f.get(1));
            friendsHashMap.get(f.get(1)).add(f.get(0));
        }
    }

    static void addFriendPoint(String user) {
        Set<String> userFriendSet = friendsHashMap.get(user);
        for (Map.Entry<String, Integer> key : points.entrySet()) {

            int currentScore = 0;
            Set<String> currentFriendSet = friendsHashMap.get(key.getKey());

            for (String userFriendName : userFriendSet) {
                if (currentFriendSet.contains(userFriendName)) {
                    currentScore += 10;
                }
            }
            key.setValue(currentScore);
        }
    }
}
