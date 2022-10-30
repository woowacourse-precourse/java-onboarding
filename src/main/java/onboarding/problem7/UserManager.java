package onboarding.problem7;

import java.util.*;

public class UserManager {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;

    private Map<String, Set<String>> friendsTable;

    public UserManager(List<List<String>> friends) {
        this.friendsTable = new HashMap<>();
        initFriendsTable(friends);
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
