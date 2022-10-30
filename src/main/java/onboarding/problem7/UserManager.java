package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<String> recommandTo(String targetUser) {
        calculateFriendsScore(targetUser);

        return friendsScore.keySet()
                .stream()
                .filter(name -> friendsTable.get(targetUser) == null ||!friendsTable.get(targetUser).contains(name))
                .filter(name-> friendsScore.get(name)>0)
                .sorted((userName1, userName2) -> {
                    if(friendsScore.get(userName2) == friendsScore.get(userName1))
                        return userName1.compareTo(userName2);
                    return friendsScore.get(userName2) - friendsScore.get(userName1);
                })
                .limit(5)
                .collect(Collectors.toList());
    }

    private void calculateFriendsScore(String targetUser) {
        addFriendsScoreBySharedFriendCount(targetUser);
        addFriendsScoreByVisitCount();
    }

    private void addFriendsScoreByVisitCount() {
        for (String visitor : visitCount.keySet()) {
            if (friendsScore.containsKey(visitor)) {
                friendsScore.put(visitor,friendsScore.get(visitor)+visitCount.get(visitor));
                continue;
            }
            friendsScore.put(visitor,visitCount.get(visitor));
        }
    }

    private void addFriendsScoreBySharedFriendCount(String targetUser) {
        for (String friend : friendsTable.keySet()) {
            if(targetUser.equals(friend)) continue;
            friendsScore.put(friend,10*countShardFriends(friend, targetUser));
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

        if(inputUserFriendSet==null) return count;
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
