package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    private static void checkId(String id) {
        if (id.length() > 30 || id.length() < 1)
            throw new IllegalArgumentException("user는 1이상 30이하여야합니다.");
    }

    private static void checkFriends(List<List<String>> friends) {
        if (friends.size() > 10000 || friends.size() < 1)
            throw new IllegalArgumentException("friends는 1이상 10000이하여야합니다.");
    }

    private static void checkVisitors(List<String> visitors) {
        if (visitors.size() > 10000)
            throw new IllegalArgumentException("visitors는 0이상 10000이하여야합니다.");
    }

    private static void checkIds(List<List<String>> friends) {
        for (List<String> friend : friends) {
            friend.forEach(Problem7::checkId);
        }
    }

    private static void checkAll(String user, List<List<String>> friends, List<String> visitors) {
        checkId(user);
        checkFriends(friends);
        checkVisitors(visitors);
        checkIds(friends);
        visitors.forEach(Problem7::checkId);
    }

    private static String getFriendId(List<String> friend, String user) {
        if (friend.indexOf(user) == 0)
            return friend.get(1);
        return friend.get(0);
    }

    private static List<String> myFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(x -> x.contains(user))
                .map(x -> getFriendId(x, user))
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        checkAll(user, friends, visitors);
        List<String> myFriends = myFriends(user, friends);

        Friends recommendFriends = new Friends();
        recommendFriends.addAcquaintance(myFriends, friends);
        recommendFriends.addVisitors(visitors);
        recommendFriends.removeOverlap(user, myFriends);

        return recommendFriends.getRecommendIds();
    }
}

class Friend implements Comparable<Friend> {
    String id;
    int score;

    public Friend(String id, int score) {
        this.id = checkId(id);
        this.score = score;
    }

    private String checkId(String id) {
        if (id.length() > 30 || id.length() < 1)
            throw new IllegalArgumentException("user는 1이상 30이하여야합니다.");
        return id;
    }

    public String getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    @Override
    public int compareTo(Friend o) {
        if (score < o.getScore())
            return 1;
        if (score > o.getScore())
            return -1;
        return id.compareTo(o.getId());
    }
}

class Friends {
    List<Friend> friends;

    public Friends() {
        friends = new ArrayList<>();
    }

    private String getAcquaintanceId(List<String> myFriends, List<String> friends) {
        if (myFriends.contains(friends.get(0)))
            return friends.get(1);
        return friends.get(0);
    }

    public void addAcquaintance(List<String> myFriends, List<List<String>> friends) {
        friends.stream()
                .filter(x -> myFriends.stream().anyMatch(x::contains))
                .forEach(x -> addFriends(getAcquaintanceId(myFriends, x), 10));
    }

    public void addVisitors(List<String> visitors) {
        visitors.forEach(x -> addFriends(x, 1));
    }

    public void removeOverlap(String user, List<String> myFriends) {
        removeUser(user);
        removeMyFriends(myFriends);
    }

    private void removeMyFriends(List<String> myFriends) {
        myFriends.stream()
                .filter(x -> (idExist(x) != null))
                .map(this::idExist)
                .forEach(x -> friends.remove(x));
    }

    private void removeUser(String user) {
        friends.remove(idExist(user));
    }

    private void addFriends(String id, int score) {
        Friend friend = idExist(id);
        if (friend != null)
            friend.addScore(score);
        else
            friends.add(new Friend(id, score));

    }

    private Friend idExist(String id) {
        return friends.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst().orElse(null);
    }

    public List<String> getRecommendIds() {
        Collections.sort(friends);
        return friends.stream()
                .limit(5)
                .map(Friend::getId)
                .collect(Collectors.toList());
    }
}