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

    private static HashMap<String, Integer> addRecommendScore(HashMap<String, Integer> friendScore, String friend, int score) {
        if (!friendScore.containsKey(friend)) {
            friendScore.put(friend, score);
        } else {
            friendScore.replace(friend, friendScore.get(friend) + score);
        }
        return friendScore;
    }
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
    private static HashMap<String, Integer> findRelationWithUserFriends(String user, List<List<String>> friends, List<String> userFriends) {
        List<String> knowUserFriends = new ArrayList<>();
        HashMap<String, Integer> friendScore = new HashMap<>();

        for(List<String> friend: friends) {
            for(String userFriend: userFriends) {
                if (friend.contains(userFriend) && !friend.contains(user)) {
                    int index = friend.indexOf(userFriend);
                    String friendWithUserFriend = friend.get(1-index);
                    knowUserFriends.add(friendWithUserFriend);
                    addRecommendScore(friendScore, friendWithUserFriend, 10);
                }
            }
        }
        return friendScore;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = findUserFriends(user, friends);
        HashMap<String, Integer> friendScore;
        friendScore = findRelationWithUserFriends(user, friends, userFriends);
        return answer;
    }
}
