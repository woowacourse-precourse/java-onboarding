package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;

    private Map<String, List<String>> friendsTable;

    public UserManager(List<List<String>> friends) {
        this.friendsTable = new HashMap<>();
        initFriendsTable(friends);
    }

    private void initFriendsTable(List<List<String>> friends) {
        for (List<String> friendRelation : friends) {
            String firstUser = friendRelation.get(FIRST_ID);
            String secondUser = friendRelation.get(SECOND_ID);
            addFriendToList(firstUser, secondUser);
            addFriendToList(secondUser, firstUser);
        }
    }

    private void addFriendToList(String key, String newFriend) {
        if (!friendsTable.containsKey(key)) {
            friendsTable.put(key, new ArrayList<>());
        }
        friendsTable.get(key).add(newFriend);
    }
}
