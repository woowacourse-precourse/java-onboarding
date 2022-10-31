package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, List<String>> friendsMap = new HashMap<>();
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void findFriendShip(List<List<String>> friends, HashMap<String, List<String>> friendsMap){
        for(int i=0; i< friends.size(); i++){
          String user1 = friends.get(i).get(0);
          String user2 = friends.get(i).get(1);
          List<String> FriendsOfUser1 = friendsMap.getOrDefault(user1, new ArrayList<>());
          FriendsOfUser1.add(user2);
          List<String> FriendsOfUser2 = friendsMap.getOrDefault(user2, new ArrayList<>());
          FriendsOfUser2.add(user1);
          friendsMap.put(user1, FriendsOfUser1);
          friendsMap.put(user2, FriendsOfUser2);
      }
    }

    public static int countRelatedFriendsWithUser(String user, String other, HashMap<String, List<String>> friendsMap){
        List<String> friendsOfUser = friendsMap.get(user);
        List<String> friendsOfOther = friendsMap.get(other);
        int numberOfRelatedFriends = 0;
        for(String friend : friendsOfOther){
            if(friendsOfUser.contains(friend)){
                numberOfRelatedFriends++;
        }
        }
        return numberOfRelatedFriends;
    }

    public static void addTenPoints(String other, int numberOfRelatedFriends, HashMap<String, Integer> scoreMap){
        scoreMap.put(other, scoreMap.getOrDefault(other,0) + 10*numberOfRelatedFriends);
    }
}
