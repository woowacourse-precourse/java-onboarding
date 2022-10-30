package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

    private static final int DEFAULT_SCORE = 0;
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int EXCEPTION_IDX = 2;
    private static final int MAX_DEPTH = 2;
    private static final int STANDARD_IDX = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> scoreBoard = new HashMap<>();

        findAcquaintance(0, user, user, friends, scoreBoard);

        System.out.println(scoreBoard);

        return answer;
    }

    public static void findAcquaintance(int depth, String targetUser, String findUser, List<List<String>> friends, Map<String, Integer> scoreBoard) {

        if (depth == MAX_DEPTH) {
            insertScore(scoreBoard, findUser, ACQUAINTANCE_SCORE);
            return;
        }

        for (List<String> friend : friends) {
            int foundFriendIdx = findFriendIdx(friend, findUser);

            if (foundFriendIdx == EXCEPTION_IDX)
                continue;

            String friendName = findFriendName(friend, foundFriendIdx);
            if (!isTargetUserSameFriend(targetUser, friendName))
                findAcquaintance(depth + 1, targetUser, friendName, friends, scoreBoard);
        }
    }

    public static int findFriendIdx(List<String> friend, String user) {
        return STANDARD_IDX - friend.indexOf(user);
    }

    public static String findFriendName(List<String> friend, Integer idx) {
        return friend.get(idx);
    }

    public static boolean isTargetUserSameFriend(String targetUser, String friend) {
        return targetUser.equals(friend);
    }

    public static void insertScore(Map<String, Integer> scoreBoard, String findUser, Integer score) {
        scoreBoard.put(findUser, scoreBoard.getOrDefault(findUser, DEFAULT_SCORE) + score);
    }
}
