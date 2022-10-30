package onboarding;

import java.util.*;

public class Problem7 {

    private static final int DEFAULT_SCORE = 0;
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int EXCEPTION_IDX = 2;
    private static final int FRIEND_DEPTH = 1;
    private static final int MAX_DEPTH = 2;
    private static final int STANDARD_IDX = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, Integer> scoreBoard = new HashMap<>();
        List<String> userFriendList = new ArrayList<>();

        findAcquaintance(0, user, user, friends, scoreBoard, userFriendList);

        System.out.println(scoreBoard);
        System.out.println(userFriendList);

        return answer;
    }

    public static void findAcquaintance(int depth, String targetUser, String findUser,
                                        List<List<String>> friends, Map<String, Integer> scoreBoard,
                                        List<String> friendsList) {

        if (depth == FRIEND_DEPTH)
            insertFriendToList(friendsList, findUser);

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
                findAcquaintance(depth + 1, targetUser, friendName, friends, scoreBoard, friendsList);
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

    public static void insertFriendToList(List<String> friendList, String name) {
        friendList.add(name);
    }
}
