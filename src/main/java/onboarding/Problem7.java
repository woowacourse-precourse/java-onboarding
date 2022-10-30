package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public  Map<String,Integer> getVisitScore(List<String> visitors, String user) {
        Map<String, Integer> visitScore = new TreeMap<>();
        int score = 1;
        for (String visitor : visitors) {
            if(visitScore.containsKey(visitor)){
                visitScore.put(visitor,visitScore.get(visitor)+1);
            }else {
                visitScore.put(visitor, 1);
            }
        }
        return  visitScore;
    }

    public List<List<String>> getFriendList (List<List<String>> friends) {
        List<List<String>> friendsList = new ArrayList<>();
        for(List<String> friend : friends){
            List<String> n = new ArrayList<>();
            n.add(0, friend.get(1));
            n.add(1,friend.get(0));
            friendsList.add(n);
            friendsList.add(friend);
        }
        return friendsList;
    }


    public  Map<String, Integer> myFriendScore (List<List<String>> friendList, String user) {
        List<List<String>> userFriends = new ArrayList<>();
        Map<String, Integer> friendScore = new TreeMap<>();
        int score = 10;
        for (List<String> friend : friendList){
            if(friend.get(0).equals(user)){
                userFriends.add(friend);
            }
        }

        for(List<String> userfriend : userFriends) {
            for(List<String> friend : friendList) {
                if(userfriend.get(1).equals(friend.get(1))){
                    if(friendScore.containsKey(friend.get(0))){
                        friendScore.put(friend.get(0),friendScore.get(friend.get(0))+score);
                    }
                        friendScore.put(friend.get(0),10);
                }
            }
        }

        return friendScore;
    }

    public int getUserList (List<List<String>> friends, String user) {
        List<String> userList = new ArrayList<>();
        for(List<String> friend : friends) {
            if(!(friend.get(0).equals(user))){
                userList.add(friend.get(0));
            }

            if(!(friend.get(1).equals(user))){
                userList.add(friend.get(1));
            }
        }
        return userList.size();
    }

}