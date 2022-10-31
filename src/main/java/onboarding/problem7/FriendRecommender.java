package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class FriendRecommender {

    private String user;
    private List<String> friendList;
    private List<List<String>> friendRelations;
    private List<String> visitors;
    private FriendPointRepository repository;

    private final int COMMON_FRIENDS_SCORE = 10;
    private final int VISIT_SCORE = 1;

    public FriendRecommender(String user, List<List<String>> friendRelations, List<String> visitors){
        this.user = user;
        this.friendRelations = friendRelations;
        this.visitors = visitors;
    }

    public List<String> recommendFriends(){
        setFriendList();
        repository = new FriendPointRepository();

        addPointWhenHaveCommonFriend();
        addPointWhenVisitUser();
        return repository.findRecommendFriendsTop5();
    }

    private void setFriendList(){
        friendList = new ArrayList<>();

        for (List<String> friendRelation : friendRelations){
            if (friendRelation.get(0).equals(user))
                friendList.add(friendRelation.get(1));
            if (friendRelation.get(1).equals(user))
                friendList.add(friendRelation.get(0));
        }
    }

    private void addPointWhenHaveCommonFriend(){
        for (List<String> relation : friendRelations){
            if (isUser(relation.get(0)) || isUser(relation.get(1))) continue;
            if (isFriend(relation.get(0)) && !isFriend(relation.get(1)))
                repository.addPoint(relation.get(1), COMMON_FRIENDS_SCORE);
            if (isFriend(relation.get(1)) && !isFriend(relation.get(0)))
                repository.addPoint(relation.get(0), COMMON_FRIENDS_SCORE);
        }
    }

    private void addPointWhenVisitUser(){
        for (String visitor : visitors){
            if (!isUser(visitor) && !isFriend(visitor))
                repository.addPoint(visitor, VISIT_SCORE);
        }
    }

    private boolean isUser(String nickname){
        return nickname.equals(user);
    }

    private boolean isFriend(String nickname){
        for (String friend : friendList){
            if (nickname.equals(friend)) return true;
        }
        return false;
    }
}
