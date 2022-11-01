package onboarding;

import java.util.*;

public class Problem7 {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;
    private static Map<String, List<String>> friendsMap = new TreeMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        makeListOfFriends(friends);

        return new ArrayList<>();
    }

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
