package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.problem7.FindList.*;

public class Score {
    private static final int SCORE_FRIEND_OF_FRIEND = 10;

    public static List<String> calculateTopThree(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = calculateScore(user, friends, visitors);

        List<Map.Entry<String, Integer>> entries = scoreMap.entrySet()
                .stream()
                .sorted(Map.Entry
                        .comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entries) {
            result.add(entry.getKey());
        }

        return result.stream()
                .limit(5)
                .filter(id -> scoreMap.get(id) > 0)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> calculateScore(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = findAlreadyFriendList(user, friends);
        List<String> friendOfFriendList = findFriendOfFriendList(user, friendList, friends);
        List<String> othersList = findOthersList(visitors, friendList, friendOfFriendList);

        Map<String, Integer> score = new HashMap<>();

        for (String id : friendOfFriendList) {
            int count = 0;

            count += countIdNumberOfFriends(friends, friendList, id) * SCORE_FRIEND_OF_FRIEND;
            count += countIdNumberOfVisitors(visitors, id);

            score.put(id, count);
        }

        for (String id : othersList) {
            int count = 0;
            count += countIdNumberOfVisitors(visitors, id);

            score.put(id, count);
        }

        return score;
    }

    private static int countIdNumberOfVisitors(List<String> visitors, String id) {
        int count = 0;

        for (String visitor : visitors) {
            if (visitor.contains(id)) {
                count++;
            }
        }

        return count;
    }

    private static int countIdNumberOfFriends(List<List<String>> friends, List<String> friendList, String id) {
        int count = 0;

        for (List<String> friend : friends) {
            count += isFriendIdExist(friend, friendList, id);
        }

        return count;
    }

    private static int isFriendIdExist(List<String> friend, List<String> friendList, String id) {
        boolean isIdExist = false;

        for (String friendId : friendList) {
            isIdExist = isIdExist || getInteger(id, friend, friendId);
        }

        if (isIdExist) {
            return 1;
        }

        return 0;
    }

    private static boolean getInteger(String id, List<String> friend, String friendId) {
        return friend.contains(friendId) && friend.contains(id);
    }
}
