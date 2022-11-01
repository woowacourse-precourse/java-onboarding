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
    public static List<String> FriendsOfUserList = new ArrayList<>();
    public static List<List<String>> Friends;
    public static ArrayList<String> AnotherFriends= new ArrayList<>();
    public static ArrayList<String> OverlapedFriends = new ArrayList<String>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User=user;
        Friends=friends;

        searchFriendsOfUser();
        HashMap<String, ArrayList<String>> anotherFriendsHashMap = getAnotherFriendHashMap(FriendsOfUserList);
        getOverlapedAnotherFriend(anotherFriendsHashMap);

        plusTen(OverlapedFriends);
        plusOne(FriendsOfUserList, visitors);
        return getRecommendedFiveFriends(FriendScore);
    }

    static void searchFriendsOfUser(){
        for (List<String> friendArray : Friends) {
            getUserContainedArray(friendArray);
        }
    }
    static void getUserContainedArray(List<String> friendArray){
        for (int friendIndex = 0; friendIndex < 2; friendIndex++) {
            addFriendOfUser(friendArray, friendIndex);
        }
    }
    static void addFriendOfUser(List<String> friendArray, int friendIndex){
        int friendOfUserIndex=(1 - friendIndex);

        if (friendArray.get(friendIndex).equals(User)) {
            FriendsOfUserList.add(friendArray.get(friendOfUserIndex));
        }
    }

    static HashMap<String, ArrayList<String>> getAnotherFriendHashMap(List<String> friendsOfUserList){
        HashMap<String, ArrayList<String>> AnotherFriendList=new HashMap<>();

        for (String friendOfUser : friendsOfUserList) {
            AnotherFriends.clear();
            searchAnotherFriend(friendOfUser);
            AnotherFriendList.put(friendOfUser, AnotherFriends);
        }
        return AnotherFriendList;
    }

    static void searchAnotherFriend(String friendOfUser){
        for (List<String> friendArray : Friends) {
            addAnotherFriend(friendArray, friendOfUser);
        }
    }

    static void addAnotherFriend(List<String> friendArray,
                                 String friendOfUser){
        for (int index = 0; index < 2; index++) {
            int anotherFriendIndex= (1 - index);

            if (isAnotherFriend(friendArray, friendOfUser, index)) {
                AnotherFriends.add(friendArray.get(anotherFriendIndex));
            }
        }
    }
    static boolean isAnotherFriend(List<String> friendArray, String friendOfUser, int index ){
        return (friendArray.get(index).equals(friendOfUser) && !friendArray.get(1-index).equals(User));
    }



    static void getOverlapedAnotherFriend(HashMap<String, ArrayList<String>> anotherFriends){

        for(String anotherfriend1: anotherFriends.keySet()){
            for(String anotherfriend2: anotherFriends.keySet()){
                if(!anotherfriend1.equals(anotherfriend2)){
                    ArrayList<String> anotherFriends1ArrayList = anotherFriends.get(anotherfriend1);
                    ArrayList<String> anotherFriends2ArrayList = anotherFriends.get(anotherfriend2);
                    findOverlapFriends(anotherFriends1ArrayList, anotherFriends2ArrayList);
                }
            }
        }
    }
    static void findOverlapFriends(ArrayList<String> ArrayListfriend1, ArrayList<String> ArrayListfriend2){
        for (String friend1 : ArrayListfriend1) {
            for (String friend2 : ArrayListfriend2) {
                if (friend1.equals(friend2)) {
                    OverlapedFriends.add(friend1);
                }
            }
        }
    }

    static void plusTen(ArrayList<String> overlapedFriends){
        for (String overlapedFriend : overlapedFriends) {
            FriendScore.put(overlapedFriend, 10);
        }
    }

    static void plusOne(List<String> friendOfUsers, List<String> visitors){
        for(String visitor: visitors){
            if(isValidVisitor(visitor, friendOfUsers)){
                FriendScore.put(visitor, FriendScore.get(visitor)+1);
            }else if(isPureVisitor(visitor,friendOfUsers)){
                FriendScore.put(visitor, 1);
            }
        }
    }
    static boolean isValidVisitor(String visitor, List<String> friendOfUsers) {
        return (FriendScore.containsKey(visitor) && !friendOfUsers.contains(visitor));
    }
    static boolean isPureVisitor(String visitor, List<String> friendOfUsers){
        return !friendOfUsers.contains(visitor);
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