package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    static HashMap<String,Integer> friendScore;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friendScore = new HashMap<>();
        findPotentialFriendAndScore(user, friends);
        findVisitedFriendAndScore(visitors);
        return arrangeList(answer);
    }
    /*
        사용자를 직접 알고있다면 -1(목록에서 제외)를
        사용자를 간접적으로 알고 있다면 10점씩 부여
     */
    private static void findPotentialFriendAndScore(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (Objects.equals(friend.get(0), user)) {
                friendScore.put(friend.get(1), -1);
                continue;
            }
            if (Objects.equals(friend.get(1), user)) {
                friendScore.put(friend.get(0), -1);
                continue;
            }
            friendScore.put(friend.get(0), friendScore.getOrDefault(friend.get(0), 0) + 10);
            friendScore.put(friend.get(1), friendScore.getOrDefault(friend.get(1), 0) + 10);
        }
    }
    /*
    사용자를 방문한 횟수당 1점씩 부여
     */
    private static void findVisitedFriendAndScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (friendScore.getOrDefault(visitor,0) != -1) {
                friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
            }
        }
    }
    /*
   점수 순으로 정렬
    */
    private static List<String> arrangeList(List<String> answer) {
        for (String Key : friendScore.keySet()) if (friendScore.get(Key)!=-1) answer.add(Key);
        answer.sort((o1, o2) -> {
            if (friendScore.get(o2) - friendScore.get(o1) > 0) return 1;
            else return 0;
        });
        if (answer.size()>5) return answer.subList(0,5);
        return answer;
    }
}
