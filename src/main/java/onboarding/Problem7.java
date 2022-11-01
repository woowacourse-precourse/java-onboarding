package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class UsersInfo {
    private String user;
    private List<List<String>> friends;
    private List<String> usersFriends;
    private List<String> visitors;
    private  List<String> recomendFriends;

    public void setUser(String name) {
        user = name;
    }

    public void setFriends(List<List<String>> list) {
        friends = list;
    }

    public void setVisitors(List<String> list) {
        visitors = list;
    }

    public String getUser() {
        return user;
    }

    public List<List<String>> getFriends() {
        return friends;
    }

    public List<String> getUsersFriends() {
        return usersFriends;
    }

    public List<String> getVisitors() {
        return visitors;
    }

    public List<String> getRecomendFriends() {
        return recomendFriends;
    }
}

class Friends extends UsersInfo {
    private List<String> friendsFriend = new ArrayList<>();

    public void findUsersFriends(){
        List<String> usersFriends = getFriends().stream()
                .filter(friendList -> friendList.contains(getUser()))
                .map(friendList -> friendList.get(findFriendsIndex(getUser(),friendList)))
                .collect(Collectors.toList());

    }

    public void findFriendsFriend() {
        Iterator<String> iterator = getUsersFriends().iterator();
        while (iterator.hasNext()) {
            String friend = iterator.next();
            List<String> list = getFriends().stream()
                    .filter(friends -> friends.contains(friend))
                    .map(friends -> friends.get(findFriendsIndex(friend, friends)))
                    .distinct()
                    .collect(Collectors.toList());
            friendsFriend = list;
        }
    }
    public int findFriendsIndex(String user, List<String> friendList) {
        return friendList.get(0).equals(user) ? 1 : 0;
    }

    public List<String> getFriendsFriend() {
        return friendsFriend;
    }

    public static boolean isIncludeUserOrFriends(String name) {
        return (getUsersFriends.contains(name) || getUser().equals(name)) ? true : false;
    }
}

class Score extends Friends {
    static final int friendsFriendScore = 10;
    static final int visitorScore = 1;
    static Map<String, Integer> recommendFriends = new HashMap<String, Integer>();

    public static List<String> limitList(List<String> recommendedList) {
        List<String> list = recommendedList.stream().limit(5).collect(Collectors.toList());
        return list;
    }

    public static List<String> orderRecommendedList() {
        List<Map.Entry<String, Integer>> entries = recommendFriends.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        List<String> orderedRecommendedList = entries.stream().map(i -> i.getKey()).collect(Collectors.toList());
        System.out.println(entries);
        return orderedRecommendedList;
    }

    public static void forCaseFriendsFriend() {
        Iterator<String> iterator = getFriendsFriend().iterator();
        while (iterator.hasNext()) {
            String recommendedFriend = iterator.next();
            if (isIncludeUserOrFriends(recommendedFriend)) {
                continue;
            }
            if (recommendedFriends.containsKey(recommendedFriend)) {
                recommendedFriends.put(recommendedFriend,
                        recommendedFriends.get(recommendedFriend) + friendsFriendScore);
                continue;
            }
            recommendedFriends.put(recommendedFriend, friendsFriendScore);
        }
    }

    public static void forCaseVisitors() {
        //removeFriends(visitors);
        Iterator<String> iterator = getVisitors().iterator();
        while (iterator.hasNext()) {
            String recommendedFriend = iterator.next();
            if (isIncludeUserOrFriends(recommendedFriend)) {
                continue;
            }
            if (recommendedFriends.containsKey(recommendedFriend)) {
                recommendedFriends.put(recommendedFriend, recommendedFriends.get(recommendedFriend) + visitorScore);
                continue;
            }
            recommendedFriends.put(recommendedFriend, visitorScore);
        }
    }
}


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
