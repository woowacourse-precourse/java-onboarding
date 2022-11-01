package onboarding.support.problem7;

import java.util.*;

public class FriendRelation {
    private final Map<String, Set<String>> friendRelations;

    public FriendRelation(List<List<String>> friends) {
        this.friendRelations = new HashMap<>();
        for (List<String> friend : friends) {
            makeFriendRelation(friendRelations, friend);
        }
    }

    private static void makeFriendRelation(Map<String, Set<String>> friendRelations, List<String> friends) {
        String firstFriend = friends.get(0);
        String secondFriend = friends.get(1);

        friendRelations.computeIfAbsent(firstFriend, value -> new HashSet<>()).add(secondFriend);
        friendRelations.computeIfAbsent(secondFriend, value -> new HashSet<>()).add(firstFriend);
    }

    public Map<String, Set<String>> getFriendRelations() {
        return friendRelations;
    }
}
