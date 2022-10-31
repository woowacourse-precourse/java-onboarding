/*
 * Problem7
 *
 * v1.1
 *
 * 2022.11.01
 *
 * 저작권 주의
 */

package onboarding;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendOfUsers= searchFriendsOfUser(user, friends);
        HashMap<String, ArrayList<String>> anotherFriends = getAnotherFriend(user,friendOfUsers, friends);
        ArrayList<String> overlapedFriend = getOverlapedFriend(anotherFriends);

        HashMap<String, Integer> friendScore = plusTen(overlapedFriend);
        friendScore = plusOne(friendScore, visitors, friendOfUsers);

        return getRecommendedFiveFriends(friendScore);
    }

    static List<String> searchFriendsOfUser(String user, List<List<String>> friends){
        List<String> friendOfUser = new ArrayList<>();

        for (List<String> friendArray : friends) {
            for (int friendIndex = 0; friendIndex < 2; friendIndex++) {
                int friendOfUserIndex=(1 - friendIndex);

                if (friendArray.get(friendIndex).equals(user)) {
                    friendOfUser.add(friendArray.get(friendOfUserIndex));
                }
            }
        }
        return friendOfUser;
    }

    static HashMap<String, ArrayList<String>> getAnotherFriend(String User,
                                                                           List<String> friendsOfUser,
                                                                           List<List<String>> friends){
        HashMap<String, ArrayList<String>> AnotherFriendList=new HashMap<String, ArrayList<String>>();

        for (String friendOfUser : friendsOfUser) {
            ArrayList<String> AnotherFriend = new ArrayList<String>();// 얘가 주인공
            AnotherFriend.clear();
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
            AnotherFriendList.put(friendOfUser, AnotherFriend);
        }
        return AnotherFriendList;
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

    static HashMap<String, Integer> plusTen(ArrayList<String> overlapedFriends){
        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        for (String overlapedFriend : overlapedFriends) {
            friendScore.put(overlapedFriend, 10);
        }

        return friendScore;
    }

    static HashMap<String, Integer> plusOne(HashMap<String, Integer> friendScore,
                                            List<String> visitors,
                                            List<String> friendOfUsers){

        for(String visitor: visitors){
            if(friendScore.containsKey(visitor) && !friendOfUsers.contains(visitor)){
                friendScore.put(visitor, friendScore.get(visitor)+1);
            }else if(!friendOfUsers.contains(visitor)){
                friendScore.put(visitor, 1);
            }
        }

        return friendScore;
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
        }else{
            recommendFiveFriends= recommendedFriends;
        }

        return recommendFiveFriends;

    }
}
