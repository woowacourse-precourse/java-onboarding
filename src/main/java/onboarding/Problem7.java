package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    private static final int FRIEND_OF_FRIEND_SCORE = 10;
    private static final int VISIT_SCORE = 1;
    private static HashMap<String, Integer> newFriendScore = new HashMap<>();
    private static HashSet<String> myFriends = new HashSet<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        myFriends.clear();
        newFriendScore.clear();

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void findMyFriends(String user, List<List<String>> friends) {
        for (List<String> friendInfo : friends) {
            String myFriend = checkMyFriendName(user, friendInfo);
            updateMyFriends(myFriend);
        }
    }

    private static void findRelatedFriends(List<List<String>> friends) {
        for (List<String> friendInfo : friends) {
            String friendOfFriend = checkFriendOfFriend(friendInfo);
            updateNewFriendScore(friendOfFriend, FRIEND_OF_FRIEND_SCORE);
        }
    }

    private static String checkMyFriendName(String user, List<String> friendInfo) {
        String userA = friendInfo.get(0);
        String userB = friendInfo.get(1);
        if(userA.equals(user)) {
            return userB;
        }
        if(userB.equals(user)) {
            return userA;
        }
        return null;
    }

    private static void updateMyFriends(String friend) {
        if(friend == null) {
            return;
        }
        myFriends.add(friend);
    }

    private static void updateNewFriendScore(String newFriend, int scoreType) {
        if(newFriend == null) {
            return;
        }
        int score = scoreType;
        if(newFriendScore.containsKey(newFriend)) {
            score += newFriendScore.get(newFriend);
            newFriendScore.put(newFriend, score);
            return;
        }
        newFriendScore.put(newFriend, score);
    }

    private static String checkFriendOfFriend(List<String> friendInfo) {
        String userA = friendInfo.get(0);
        String userB = friendInfo.get(1);
        if(myFriends.contains(userA)) {
            return userB;
        }
        if(myFriends.contains(userB)) {
            return userA;
        }
        return null;
    }

}
