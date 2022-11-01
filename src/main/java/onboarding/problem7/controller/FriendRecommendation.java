package onboarding.problem7.controller;

import onboarding.problem7.domain.User;

import java.util.HashMap;
import java.util.List;

public class FriendRecommendation {
    private String targetUserName;
    private User targetUser;
    private List<List<String>> friends;
    private List<String> visitors;
    private HashMap<String, User> userTable = new HashMap<>();

    public FriendRecommendation(String targetUserName, List<List<String>> friends, List<String> visitors){
        this.targetUserName = targetUserName;
        this.friends = friends;
        this.visitors = visitors;
        this.targetUser = new User(targetUserName);
    }

    private void addAllFriendListUserToTable(){
        for(List<String> friendRelation: friends){
            putUser(friendRelation.get(0));
            putUser(friendRelation.get(1));
        }
    }

    private void addAllFriendRelation(){
        for(List<String> friendRelation: friends){
            crossAddFriend(friendRelation);
        }
    }

    private void crossAddFriend(List<String> friendRelation){
        userTable.get(friendRelation.get(0)).addFriend(friendRelation.get(1));
        userTable.get(friendRelation.get(1)).addFriend(friendRelation.get(0));
    }


    private void putUser(String name){
        if(!alreadyInHashMap(name)){
            userTable.put(name, new User(name));
        }
    }
    private boolean alreadyInHashMap(String name){
        return userTable.containsKey(name);
    }


}
