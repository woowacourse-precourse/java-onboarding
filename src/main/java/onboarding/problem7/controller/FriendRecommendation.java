package onboarding.problem7.controller;

import onboarding.problem7.domain.User;
import onboarding.problem7.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendRecommendation {
    private String targetUserName;
    private User targetUser;
    private List<List<String>> friends;
    private List<String> visitors;
    private HashMap<String, User> userTable = new HashMap<>();
    private HashMap<String, Integer> recommendPointTable = new HashMap<>();

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
        if(!alreadyInHashMap(userTable,name)){
            userTable.put(name, new User(name));
        }
    }
    private boolean alreadyInHashMap(HashMap hashMap, String name){
        return hashMap.containsKey(name);
    }

    private void updateFriendOfFriendPoints(){
        for(String friendName: targetUser.getFriendList()){
            User friend = userTable.get(friendName);
            giveFriendOfFriendPoints(friend.getFriendList());
        }
    }

    public void updateVisitorPoints(){
        for(String visitor: visitors){
            addPointsToRecommendPointTable(visitor, Constants.POINT_OF_VISITOR);
        }
    }

    private void giveFriendOfFriendPoints(ArrayList<String> friendList){
        for(String name: friendList){
            addPointsToRecommendPointTable(name, Constants.POINT_OF_FRIEND_OF_FRIEND);
        }
    }

    private void addPointsToRecommendPointTable(String name, int point){
        if(!(isMyFriend(name) || isMe(name))){
            givePoint(name, point);
        }
    }

    private boolean isMyFriend(String name){
        return targetUser.getFriendList().contains(name);
    }

    private boolean isMe(String name){
        return name.equals(targetUserName);
    }

    private void givePoint(String name, int point){
        recommendPointTable.put(name, calculateRecommendPoint(name, point));
    }

    private int calculateRecommendPoint(String name, int point){
        if(alreadyInHashMap(recommendPointTable, name)){
            return recommendPointTable.get(name)+point;
        }
        return point;
    }


}
