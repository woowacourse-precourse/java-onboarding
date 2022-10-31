package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendOfUsers= searchFriendsOfUser(user, friends);
        HashMap<String, ArrayList<String>> anotherFriends = getAnotherFriendUsingHashMap(user,friendOfUsers, friends);
        ArrayList<String> overlapedFriends = new ArrayList<String>();

        for(String anotherfriend1: anotherFriends.keySet()){
            for(String anotherfriend2: anotherFriends.keySet()){
                if(!anotherfriend1.equals(anotherfriend2)){
                    overlapedFriends.addAll(findOverlapFriend(anotherFriends.get(anotherfriend1), anotherFriends.get(anotherfriend2)));
                }
            }
        }

        HashMap<String, Integer> friendScore = plusTen(overlapedFriends);
        friendScore = plusOne(friendScore, visitors, friendOfUsers);

        return getRecommendedFiveFriends(friendScore);

    }

    static List<String> searchFriendsOfUser(String user, List<List<String>> friends){
        List<String> friendOfUser = new ArrayList<>();
        for (List<String> friend : friends) {
            for (int friendIndex = 0; friendIndex < 2; friendIndex++) {
                if (friend.get(friendIndex).equals(user)) {
                    friendOfUser.add(friend.get(1 - friendIndex));
                }
            }
        }
        return friendOfUser;
    }

    static HashMap<String, ArrayList<String>> getAnotherFriendUsingHashMap(String User,
                                                                           List<String> friendsOfUser,
                                                                           List<List<String>> friends){

        HashMap<String, ArrayList<String>> AnotherFriendList=new HashMap<String, ArrayList<String>>();
        for (String s : friendsOfUser) {
            ArrayList<String> AnotherFriend = new ArrayList<String>();// 얘가 주인공
            AnotherFriend.clear();
            for (List<String> friend : friends) {
                for (int j = 0; j < 2; j++) {
                    if (friend.get(j).equals(s) && !friend.get(1-j).equals(User)) {
                        AnotherFriend.add(friend.get(1 - j));
                    }
                }
            }
            AnotherFriendList.put(s, AnotherFriend);
        }
        return AnotherFriendList;
    }

    static ArrayList<String> findOverlapFriend(ArrayList<String> friend1, ArrayList<String> friend2){
        ArrayList<String> overlapedFriend = new ArrayList<String>();
        for(int i=0; i< friend1.size(); i++){
            for(int j=0; j< friend2.size(); j++){
                if(friend1.get(i).equals(friend2.get(j))){
                    overlapedFriend.add(friend1.get(i));
                }
            }
        }
        return overlapedFriend;
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
        ArrayList<String> recommendedFiveFriends = new ArrayList<>();

        recommendedFriends.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return friendScore.get(o2).compareTo(friendScore.get(o1));
            }
        });
        if(recommendedFriends.size() >5){
            for(int i=0; i<5; i++){
                recommendedFiveFriends.add(recommendedFriends.get(i));
            }
        }else{
            recommendedFiveFriends= recommendedFriends;
        }

        return recommendedFiveFriends;

    }
}
