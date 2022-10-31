package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
