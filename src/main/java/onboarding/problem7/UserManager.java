package onboarding.problem7;

import java.util.*;

public class UserManager {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;

    private Map<String, Set<String>> friendsTable;
    private Map<String,Integer> friendsScore;
    private Map<String,Integer> visitCount;

    public UserManager(List<List<String>> friends,List<String> visitors) {
        this.friendsTable = new HashMap<>();
        this.friendsScore = new HashMap<>();
        this.visitCount = new HashMap<>();
        initFriendsTable(friends);
        initVisitCount(visitors);
    }

    private void initFriendsScore(String targetUser) {
        for (String friend : friendsTable.keySet()) {
            if(targetUser.equals(friend)) continue;
            friendsScore.put(friend, visitCount.get(friend) + countShardFriends(friend, targetUser));
        }
    }

    private void initVisitCount(List<String> visitors) {
        for (String visitor : visitors) {
            visitCount.put(visitor, visitCount.getOrDefault(visitor, 0) + 1);
        }
    }

    private int countShardFriends(String currentUser, String inputUser) {
        int count = 0;
        Set<String> inputUserFriendSet = friendsTable.get(inputUser);

        for (String sharedFriend : friendsTable.get(currentUser)) {
            if (inputUserFriendSet.contains(sharedFriend)) count++;
        }

        return count;
    }

    private void initFriendsTable(List<List<String>> friends) {
        for (List<String> friendRelation : friends) {
            String firstUser = friendRelation.get(FIRST_ID);
            String secondUser = friendRelation.get(SECOND_ID);
            addFriendToSet(firstUser, secondUser);
            addFriendToSet(secondUser, firstUser);
        }
    }

    private void addFriendToSet(String key, String newFriend) {
        if (!friendsTable.containsKey(key)) {
            friendsTable.put(key, new HashSet<>());
        }
        friendsTable.get(key).add(newFriend);
    }
}
