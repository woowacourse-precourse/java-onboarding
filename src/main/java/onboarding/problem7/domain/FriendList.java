package onboarding.problem7.domain;

import java.util.*;

public class FriendList {

    private final Map<String, Set<String>> friendList;

    public FriendList(List<List<String>> friends) {
        this.friendList = new HashMap<>();
        friends.forEach(friendIdList -> addFriendEachOther(friendIdList.get(0), friendIdList.get(1)));
    }

    private void addFriendEachOther(String firstFriend, String secondFriend) {
        addFriendList(firstFriend, secondFriend);
        addFriendList(secondFriend, firstFriend);
    }

    private void addFriendList(String me, String friend) {
        Set<String> firstFriendList = friendList.getOrDefault(me, new HashSet<>());
        firstFriendList.add(friend);
        friendList.put(me, firstFriendList);
    }

    public Set<String> friendList(String id) {
        return this.friendList.getOrDefault(id, new HashSet<>());
    }

    public Map<String, Set<String>> allFriendList() {
        return this.friendList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendList that = (FriendList) o;
        return Objects.equals(friendList, that.friendList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendList);
    }
}
