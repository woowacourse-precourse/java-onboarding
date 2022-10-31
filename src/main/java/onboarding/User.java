package onboarding;

import java.util.*;

/*
problem 7에 사용되는 클래스 입니다.
 */
class User {
    String name;
    List<String> friendsList = new ArrayList<>();
    HashMap<String, RecommendFriend> recommendFriendsHash = new HashMap<>();

    public User(String name) {
        this.name = name;
    }

    //이미 친구관계인 사람을 넣는다.
    void addFriends(String name) {
        friendsList.add(name);
    }

    //친구의 친구인 경우 점수를 부여한다.
    void addLinkedFriendsPoint(String name) {
        if (isNotInFriendsList(name)) {
            addFriendRecommendFriedanHash(name);
            recommendFriendsHash.get(name).addLinkedFriendPoint();
        }
    }

    //타임라인에 방문한 경우 점수를 부여한다.
    void addVisitededFriendsProint(String name) {
        if (isNotInFriendsList(name)) {
            addFriendRecommendFriedanHash(name);
            recommendFriendsHash.get(name).addVisitedFriendPoint();
        }
    }

    //만약 추천친구 hash에 있다면 추가하지 않고 없다면 추가한다.
    private void addFriendRecommendFriedanHash(String name) {
        if (!recommendFriendsHash.containsKey(name)) {
            recommendFriendsHash.put(name, new RecommendFriend(name, 0));
        }
    }

    //이미 user의 친구이거나 객체 자신인경우 제외한다.
    private boolean isNotInFriendsList(String name) {
        if (name.equals(this.name)) return false;
        else return !friendsList.contains(name);
    }

}
