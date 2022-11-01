package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;
    private static final int ZERO_SCORE = 0;
    private static final int VISIT_SCORE = 1;
    private static final int SAME_FRIEND_SCORE = 10;

    private static Map<String, List<String>> friendsMap = new TreeMap<>();
    private static Map<String, Integer> scoreMap = new TreeMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeListOfFriends(friends);
        makeScoreMapOfFriendsList(user, visitors);
        return new ArrayList<>();
    }

    private static void makeScoreMapOfFriendsList(String user, List<String> visitors) {
        List<String> userFriendList = friendsMap.get(user);
        for (String key : friendsMap.keySet()) {
            scoreMap.put(key, scoreMap.getOrDefault(key, ZERO_SCORE) + calcSameFriendsScore(userFriendList, key));
        }
        for (String visitor : visitors) {
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor, ZERO_SCORE) + VISIT_SCORE);
        }
    }

    private static int calcSameFriendsScore(List<String> userFriendList, String key) {
        return SAME_FRIEND_SCORE * getCountOfSameFriends(friendsMap.get(key), userFriendList);
    }

    private static int getCountOfSameFriends(List<String> someoneFriendList, List<String> userFriendList) {
        int count = 0;
        for (String someone : someoneFriendList) {
            if (userFriendList.contains(someone)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 메소드 이름 수정 필요
     */
    private static void makeListOfFriends(List<List<String>> friends) {
        for (List<String> twoFriends : friends) {
            putToFriendsMap(twoFriends.get(FIRST_ID), twoFriends.get(SECOND_ID));
            putToFriendsMap(twoFriends.get(SECOND_ID), twoFriends.get(FIRST_ID));
        }
    }

    private static void putToFriendsMap(String key, String valueOfList) {
        if (friendsMap.containsKey(key)) {
            friendsMap.get(key).add(valueOfList);
            return;
        }
        ArrayList<String> valueList = new ArrayList<>();
        valueList.add(valueOfList);
        friendsMap.put(key, valueList);
    }

}
