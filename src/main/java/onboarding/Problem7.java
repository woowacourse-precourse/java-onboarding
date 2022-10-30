package onboarding;

import java.util.*;

public class Problem7 {

    private static final int DEFAULT_SCORE = 0;
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int EXCEPTION_IDX = 2;
    private static final int FRIEND_DEPTH = 1;
    private static final int MAX_DEPTH = 2;
    private static final int STANDARD_IDX = 1;
    private static final int MAX_RESULT_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> scoreBoard = new HashMap<>();
        List<String> userFriendList = new ArrayList<>();

        findAcquaintance(0, user, user, friends, scoreBoard, userFriendList);
        findVisitors(visitors, userFriendList, scoreBoard);

        List<String> answer = new ArrayList<>(scoreBoard.keySet());

        return makeRecommendResult(answer, scoreBoard);
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

    public static void findVisitors(List<String> visitors, List<String> userFriendList, Map<String, Integer> scoreBoard) {
        for (String visitor : visitors) {
            if (!userFriendList.contains(visitor))
                insertScore(scoreBoard, visitor, VISITOR_SCORE);
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

    public static List<String> makeRecommendResult(List<String> answer, Map<String, Integer> scoreBoard) {
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (scoreBoard.get(o1).equals(scoreBoard.get(o2)))
                    return o1.compareTo(o2);

                return scoreBoard.get(o2).compareTo(scoreBoard.get(o1));
            }
        });

        if (answer.size() > MAX_RESULT_SIZE)
            return answer.subList(0, MAX_RESULT_SIZE);
        else
            return answer;
    }
}
