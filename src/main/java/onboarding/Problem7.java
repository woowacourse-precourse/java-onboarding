package onboarding;

import java.util.*;

public class Problem7 {
    /* 기능 단위
     * 1. user의 친구를 찾음 (findUserFriends)
     * 2. user의 친구 중에서 user 제외 관계가 있는 친구 찾음 (findRelationWithUserFriends)
     * 3. user의 타임라인을 방문한 친구 찾음 (findVisitors)
     * 3. user 친구와 관계가 있는 친구와 user 타임라인에 방문한 친구의 점수를 올려줌 (addRecommendScore)
     * 4. user의 direct 친구는 제거 (removeUserFriends)
     * */

    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<String>();
        for(List<String> friend: friends) {
            if (friend.contains(user)) {
                int index = friend.indexOf(user);
                userFriends.add(friend.get(1-index));
            }
        }
        return userFriends;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = findUserFriends(user, friends);
        return answer;
    }
}
