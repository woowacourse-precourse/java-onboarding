package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 사용자의 타임 라인에 방문한 친구에게 추천 점수를 부여한다.
     */
    private static void addVisitorScore(Map<String, Integer> scores, List<String> visitors) {
        for (String visitor : visitors) {
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    /**
     * 사용자의 먼 친구(함께 아는 친구)에게 추천 점수를 부여한다.
     */
    private static void addDistantFriendScore(Map<String, Integer> scores, List<String> distantFriends) {
        for (String friend : distantFriends) {
            scores.put(friend, scores.getOrDefault(friend, 0) + 10);
        }
    }

    /**
     * 사용자와 먼 친구(함께 아는 친구) 목록을 반환한다.
     */
    private static List<String> findDistantFriends(String user, List<String> closeFriends, List<List<String>> friends) {
        List<String> distantFriends = new ArrayList<>();

        for (String closeFriend : closeFriends) {
            distantFriends = findCloseFriends(closeFriend, friends);
            distantFriends.remove(user);
        }

        return distantFriends;
    }

    /**
     * 사용자와 가까운 친구 목록을 반환한다.
     */
    private static List<String> findCloseFriends(String user, List<List<String>> friends) {
        List<String> closeFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (!name.equals(user)) {
                        closeFriends.add(name);
                    }
                }
            }
        }

        return closeFriends;
    }
}
