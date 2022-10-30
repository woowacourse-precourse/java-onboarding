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
            insertScore(scoreBoard, findUser);
            return;
        }

        for (List<String> friend : friends) {
            int foundFriendIdx = findFriendIdx(friend, findUser);

            if (foundFriendIdx == 2)
                continue;

            String friendName = findFriendName(friend, foundFriendIdx);
            if (!isTargetUserSameFriend(targetUser, friendName))
                findAcquaintance(depth + 1, targetUser, friendName, friends, scoreBoard);
        }
    }

    public static int findFriendIdx (List<String> friend, String user) {
        return 1 - friend.indexOf(user);
    }

    public static String findFriendName(List<String> friend, Integer idx) {
        return friend.get(idx);
    }

    public static boolean isTargetUserSameFriend(String targetUser, String friend) {
        return targetUser.equals(friend);
    }

    public static void insertScore(Map<String, Integer> scoreBoard, String findUser) {
        scoreBoard.put(findUser, scoreBoard.getOrDefault(findUser, 0) + 10);
    }
}
