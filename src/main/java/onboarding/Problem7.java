package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> scoreBoard = new HashMap<>();

        findAcquaintance(0, user, user, friends, scoreBoard);

        System.out.println(scoreBoard);

        return answer;
    }

    public static void findAcquaintance(int depth, String targetUser, String findUser, List<List<String>> friends, Map<String, Integer> scoreBoard) {

        if (depth == 2) {
            scoreBoard.put(findUser, scoreBoard.getOrDefault(findUser, 0) + 10);
            return;
        }

        for (List<String> friend : friends) {
            int foundFriendIdx = 1 - friend.indexOf(findUser);
            if (foundFriendIdx == 2)
                continue;
            else {
                if (!targetUser.equals(friend.get(foundFriendIdx)))
                    findAcquaintance(depth + 1, targetUser, friend.get(foundFriendIdx), friends, scoreBoard);
            }
        }
    }
}
