package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String, Integer> userScoreHashMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, ArrayList<String>> friendsHashMap = getFriendsHashMap(friends);
        setUserScoreHashMap(user, friendsHashMap, visitors);
        return getHighScoreList();
    }

    public static HashMap<String, ArrayList<String>> getFriendsHashMap(List<List<String>> friendsList) {
        HashMap<String, ArrayList<String>> friendsHashMap = new HashMap<>();
        for (List<String> friend : friendsList) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            putUserRelation(friendsHashMap, user1, user2);
            putUserRelation(friendsHashMap, user2, user1);
        }
        return friendsHashMap;
    }

    public static void putUserRelation(HashMap<String, ArrayList<String>> friendsHashMap, String user1, String user2) {
        if (!friendsHashMap.containsKey(user1)) {
            friendsHashMap.put(user1, new ArrayList<>(List.of(user2)));
            return;
        }
        friendsHashMap.get(user1).add(user2);
    }

    public static void setUserScoreHashMap(String user, HashMap<String, ArrayList<String>> friendsHashMap,
            List<String> visitors) {
        ArrayList<String> friendsList = new ArrayList<>();
        if (friendsHashMap.containsKey(user)) {
            friendsList = friendsHashMap.get(user);
        }
        HashSet<String> excludeUser = new HashSet<>(friendsList);
        excludeUser.add(user);
        addScoreToTwoHopUsers(friendsHashMap, friendsList, excludeUser);
        addScoreToVisitors(visitors, excludeUser);
    }

    public static void addScoreToTwoHopUsers(HashMap<String, ArrayList<String>> friendsHashMap, ArrayList<String> friendsList,
        HashSet<String> excludeUser) {
        for (String friend : friendsList) {
            ArrayList<String> twoHopFriendsList = friendsHashMap.get(friend);
            for (String twoHopFriend : twoHopFriendsList) {
               addScoreIfAvailable(twoHopFriend, excludeUser, 10);
            }
        }
    }

    public static void addScoreToVisitors(List<String> visitors, HashSet<String> excludeUser) {
        for (String visitor : visitors) {
            addScoreIfAvailable(visitor, excludeUser, 1);
        }
    }

    public static void addScoreIfAvailable(String twoHopFriend, HashSet<String> excludeUser, int score) {
        if (!excludeUser.contains(twoHopFriend)) {
            if (!userScoreHashMap.containsKey(twoHopFriend)) {
                userScoreHashMap.put(twoHopFriend, score);
                return;
            }
            userScoreHashMap.put(twoHopFriend, userScoreHashMap.get(twoHopFriend) + score);
        }
    }

    public static List<String> getHighScoreList() {
        ArrayList<String> highScoreList = new ArrayList<>(userScoreHashMap.keySet());
        Collections.sort(highScoreList, (a, b) ->
            (userScoreHashMap.get(a) == userScoreHashMap.get(b) ? a.compareTo(b) : userScoreHashMap.get(b)-userScoreHashMap.get(a)));
        int highScoreLen = highScoreList.size();
        int returnSize = Math.min(5, highScoreLen);
        return highScoreList.subList(0,returnSize);
    }
}
