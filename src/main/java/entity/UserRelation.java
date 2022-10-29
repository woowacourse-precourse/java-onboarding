package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRelation {
    private String user;
    private Map<String, Set<String>> friendsRelations = new HashMap<>();
    private Set<String> userFriends = new HashSet<>();
    private List<String> notUserFriends = new ArrayList<>();
    private List<String> visitors = new ArrayList<>();
    private List<String> notUserFriendVisitors = new ArrayList<>();

    protected UserRelation() {}

    public UserRelation(String user, List<List<String>> friendsRelationList, List<String> visitors) {
        this.user = user;
        this.visitors = visitors;
        createFriendsRelations(friendsRelationList);
        createUserFriends(friendsRelations);
        createNotUserFriends(friendsRelations);
        createNotUserFriendVisitors();
    }

    private void createFriendsRelations(List<List<String>> friends) {
        friends.forEach(list -> {
            addAtoBInMap(list.get(0), list.get(1));
            addAtoBInMap(list.get(1), list.get(0));
        });
    }

    private void addAtoBInMap(String a, String b) {
        if (friendsRelations.containsKey(b))
            friendsRelations.get(b).add(a);
        else
            friendsRelations.put(b, new HashSet<>(Collections.singletonList(a)));
    }

    private void createUserFriends(Map<String, Set<String>> friendsRelationMap) {
        userFriends = friendsRelationMap.keySet().stream()
                .filter(userId -> userId.equals(user) || friendsRelationMap.get(user).contains(userId))
                .collect(Collectors.toSet());
    }

    private void createNotUserFriends(Map<String, Set<String>> friendsRelationMap) {
        notUserFriends = friendsRelationMap.keySet().stream()
                .filter(userId -> !userFriends.contains(userId))
                .collect(Collectors.toList());
    }

    private void createNotUserFriendVisitors() {
        notUserFriendVisitors = visitors.stream()
                .filter(visitor -> !userFriends.contains(visitor))
                .collect(Collectors.toList());
    }

    public String getUser() {
        return user;
    }

    public Map<String, Set<String>> getFriendsRelations() {
        return friendsRelations;
    }

    public Set<String> getUserFriends() {
        return userFriends;
    }

    public List<String> getNotUserFriends() {
        return notUserFriends;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public List<String> getNotUserFriendVisitors() {
        return notUserFriendVisitors;
    }
}
