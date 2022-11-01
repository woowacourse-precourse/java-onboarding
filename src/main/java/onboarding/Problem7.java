package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    // 새친구 점수 추가
    private static void NewFriends(String user, List<List<String>> friends, String oldFriend) {
        // user의 새 친구 찾기
        for (List<String> relation : friends) {
            if(relation.contains(oldFriend) && !relation.contains(user)){
                String newFriend = relation.get(0)==oldFriend ? relation.get(1) : relation.get(0);
                addPoint(newFriend, 10);
            }
        }
    }

    // user 친구 찾기
    private static List<String> getOldFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();
        // user 친구 찾기
        for (List<String> relation : friends){
            if(relation.contains(user)) {
                result.add(relation.get(0)==user ? relation.get(1) : relation.get(0));
            }
        }
        return result;
    }

    // 추천 점수 추가
    static void addPoint(String user, int point) {
        if(friendPoint.containsKey(user)) {
            friendPoint.replace(user, friendPoint.get(user)+point);
        } else {
            friendPoint.put(user, point);
        }
    }
}
