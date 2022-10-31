package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, List<String>> friendsMap = new HashMap<>();
        findFriendShip(friends, friendsMap);
        calculateRelatedFriends(user, friendsMap, scoreMap);
        calculateVisitor(user, visitors, scoreMap);
        removeUserFriends(friendsMap.get(user), scoreMap);
        removeZeroScore(scoreMap);
        List<String> recommendedFriends = sortMapByScoreAndName(new ArrayList<>(scoreMap.keySet()), scoreMap);
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

    public static void calculateRelatedFriends(String user, HashMap<String, List<String>> friendsMap, HashMap<String, Integer> scoreMap){
        if(!friendsMap.containsKey(user)){
            return;
        }

        for(String friend : friendsMap.keySet()){
            if(friend.equals(user)){
                continue;
            }
            int numberOfRelatedFriends = countRelatedFriendsWithUser(user, friend, friendsMap);
            addTenPoints(friend, numberOfRelatedFriends, scoreMap);
        }
    }

    public static void calculateVisitor(String user, List<String> visitors, HashMap<String, Integer> scoreMap){
        visitors.stream().forEach(visitor -> addOnePoint(user, visitor, scoreMap));
    }

    public static void removeUserFriends(List<String> userFriends, HashMap<String, Integer> scoreMap){
        if(userFriends==null){
            return;
        }
        for(String userFriend: userFriends){
            scoreMap.remove(userFriend);
        }
    }

    public static void removeZeroScore(HashMap<String, Integer> scoreMap){
        List<String> friends = new ArrayList<>(scoreMap.keySet());
        for(String friend: friends){
            if(scoreMap.get(friend)==0){
                scoreMap.remove(friend);
            }
        }
    }

    public static List<String> sortMapByScoreAndName(List<String> recommendedFriends, HashMap<String, Integer> scoreMap ) {
        recommendedFriends.sort((user1, user2) -> {
            if (Objects.equals(scoreMap.get(user1), scoreMap.get(user2))) {
              return user1.compareTo(user2);
            }
            return scoreMap.get(user2) - scoreMap.get(user1);
        });
        return recommendedFriends;
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

    public static void addOnePoint(String user, String visitor, HashMap<String, Integer> scoreMap){
        if(visitor!=user){
            scoreMap.put(visitor, scoreMap.getOrDefault(visitor,0)+1);
        }
    }
}
