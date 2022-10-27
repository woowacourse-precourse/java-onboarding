package onboarding;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userAndFriendList = getFriendList(friends, user);
        userAndFriendList.add(user);

        HashMap<String, Integer> strangerScoreMap = getStrangerScoreMap(userAndFriendList, friends);

        return answer;
    }



    private static HashMap<String, Integer> getStrangerScoreMap(List<String> userAndFriendList, List<List<String>> friends) {
        HashMap<String, Integer> strangerScoreMap = new HashMap<>();
        for (List<String> friendRelation : friends) {
            makeMapAndCalScore(friendRelation, userAndFriendList, strangerScoreMap);
        }
        return strangerScoreMap;
    }

    private static void makeMapAndCalScore(List<String> friendRelation, List<String> userAndFriendList, HashMap<String, Integer> strangerScoreMap) {
        String firstFriend = friendRelation.get(0);
        String secondFriend = friendRelation.get(1);

        if (userAndFriendList.contains(firstFriend) && userAndFriendList.contains(secondFriend)) {
            return;
        }
        if (userAndFriendList.contains(firstFriend) && !userAndFriendList.contains(secondFriend)) {
            strangerScoreMap.put(secondFriend, strangerScoreMap.getOrDefault(secondFriend, 0) + 10);
            return;
        }
        if (!userAndFriendList.contains(firstFriend) && userAndFriendList.contains(secondFriend)) {
            strangerScoreMap.put(firstFriend, strangerScoreMap.getOrDefault(firstFriend, 0) + 10);
            return;
        }
        strangerScoreMap.put(firstFriend, strangerScoreMap.getOrDefault(firstFriend, 0));
        strangerScoreMap.put(secondFriend, strangerScoreMap.getOrDefault(secondFriend, 0));
    }


    private static List <String> getFriendList(List<List<String>> friends, String user) {
        List<String> friendList = new ArrayList<>();
        for (List<String> friendRelation : friends) {
            if (isFriendWithUser(friendRelation, user)) {
                String friend = getFriend(friendRelation, user);
                friendList.add(friend);
            }
        }
        return friendList;
    }

    private static String getFriend(List<String> friendRelation, String user) {
        if (friendRelation.get(0).equals(user)) {
            return friendRelation.get(1);
        }
        return friendRelation.get(0);
    }

    private static boolean isFriendWithUser(List<String> friendRelation, String user) {
        return friendRelation.contains(user);
    }
}
