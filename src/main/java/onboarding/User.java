package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    String name;
    List<String> friendsList = new ArrayList<>();
    HashMap<String, RecommendFriend> recommendFriendsHash = new HashMap<>();


    public User(String name) {
        this.name = name;
    }

    //이미 친구인 사람을 넣음
    void addFriends(String name) {
        friendsList.add(name);
    }

    //친구의 친구인 경우
    void addLinkedFriendsPoint(String name) {
        //이미 친구이거나 자신인경우는 제외한다.
        if (isNotInFriendsList(name)) {
            if (!recommendFriendsHash.containsKey(name)) {
                addRecommendsFriends(name);
            }
            recommendFriendsHash.get(name).addLinkedFriendPoint();
        }
    }

    void addVisitededFriendsProint(String name) {
        if(isNotInFriendsList(name)) {
            if (!recommendFriendsHash.containsKey(name)) {
                addRecommendsFriends(name);
            }
            recommendFriendsHash.get(name).addVisitedFriendPoint();
        }
    }


    //새로운 추천친구 생성
    private void addRecommendsFriends(String name) {
        recommendFriendsHash.put(name, new RecommendFriend(name,0));
    }

    //이미 user의 친구이거나 객체 자신인지
    private boolean isNotInFriendsList(String name) {
        if(name.equals(this.name)) return false;
        else return !friendsList.contains(name);
    }

}
