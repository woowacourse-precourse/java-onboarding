/*
 * Problem7
 *
 * v1.2
 *
 * 2022.11.01
 *
 * 저작권 주의
 */
package onboarding;
import java.util.*;

public class Problem7 {
    public static String User;
    public static HashMap<String, Integer> FriendScore= new HashMap<>();
    public static List<String> FriendsOfUser = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User=user;

        searchFriendsOfUser(friends);
        HashMap<String, ArrayList<String>> anotherFriends = getAnotherFriend(FriendsOfUser, friends);
        ArrayList<String> overlapedFriend = getOverlapedFriend(anotherFriends);

        plusTen(overlapedFriend);
        plusOne(FriendsOfUser, visitors);
        return getRecommendedFiveFriends(FriendScore);
    }

    static void searchFriendsOfUser(List<List<String>> friends){
        for (List<String> friendArray : friends) {
            getUserContainedArray(friendArray);
        }
    }
    static void getUserContainedArray(List<String> friendArray){
        for (int friendIndex = 0; friendIndex < 2; friendIndex++) {
            getFriendOfUser(friendArray, friendIndex);
        }
    }
    static void getFriendOfUser(List<String> friendArray, int friendIndex){
        int friendOfUserIndex=(1 - friendIndex);

        if (friendArray.get(friendIndex).equals(User)) {
            FriendsOfUser.add(friendArray.get(friendOfUserIndex));
        }
    }

    static HashMap<String, ArrayList<String>> getAnotherFriend(List<String> friendsOfUser,
                                                               List<List<String>> friends){
        HashMap<String, ArrayList<String>> AnotherFriendList=new HashMap<>();

        for (String friendOfUser : friendsOfUser) {
            ArrayList<String> anotherFriend = new ArrayList<String>();// 얘가 주인공
            anotherFriend.clear();
            anotherFriend= getAnotherFriend(friendOfUser, friends, anotherFriend);
            AnotherFriendList.put(friendOfUser, anotherFriend);
        }
        return AnotherFriendList;
    }

    static ArrayList<String> getAnotherFriend(String friendOfUser,
                                              List<List<String>> friends,
                                              ArrayList<String> AnotherFriend){
        for (List<String> friendArray : friends) {
            for (int index = 0; index < 2; index++) {
                int anotherFriendIndex= (1 - index);

                if (friendArray.get(index).equals(friendOfUser)
                        &&
                        !friendArray.get(anotherFriendIndex).equals(User)) {
                    AnotherFriend.add(friendArray.get(anotherFriendIndex));
                }
            }
        }
        return AnotherFriend;
    }




    static ArrayList<String> findOverlapFriend(ArrayList<String> ArrayListfriend1, ArrayList<String> ArrayListfriend2){
        ArrayList<String> overlapedFriend = new ArrayList<String>();

        for (String friend1 : ArrayListfriend1) {
            for (String friend2 : ArrayListfriend2) {
                if (friend1.equals(friend2)) {
                    overlapedFriend.add(friend1);
                }
            }
        }
        return overlapedFriend;
    }
    static ArrayList<String> getOverlapedFriend(HashMap<String, ArrayList<String>> anotherFriends){
        ArrayList<String> overlapedFriends = new ArrayList<String>();

        for(String anotherfriend1: anotherFriends.keySet()){
            for(String anotherfriend2: anotherFriends.keySet()){
                if(!anotherfriend1.equals(anotherfriend2)){
                    overlapedFriends.addAll(findOverlapFriend(anotherFriends.get(anotherfriend1), anotherFriends.get(anotherfriend2)));
                }
            }
        }
        return overlapedFriends;
    }

    static void plusTen(ArrayList<String> overlapedFriends){

        for (String overlapedFriend : overlapedFriends) {
            FriendScore.put(overlapedFriend, 10);
        }
    }

    static void plusOne(List<String> friendOfUsers, List<String> visitors){

        for(String visitor: visitors){
            if(FriendScore.containsKey(visitor) && !friendOfUsers.contains(visitor)){
                FriendScore.put(visitor, FriendScore.get(visitor)+1);
            }else if(!friendOfUsers.contains(visitor)){
                FriendScore.put(visitor, 1);
            }
        }
    }
    static ArrayList<String> getRecommendedFiveFriends(HashMap<String, Integer> friendScore){
        ArrayList<String> recommendedFriends = new ArrayList<>(friendScore.keySet());
        ArrayList<String> recommendFiveFriends = new ArrayList<>();

        recommendedFriends.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return friendScore.get(o2).compareTo(friendScore.get(o1));
            }
        });

        if(recommendedFriends.size() >5){
            for(int i=0; i<5; i++){
                recommendFiveFriends.add(recommendedFriends.get(i));
            }
        }
        recommendFiveFriends= recommendedFriends;

        return recommendFiveFriends;

    }
}