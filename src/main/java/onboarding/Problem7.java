package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem7 {
    final static int friendA = 0;
    final static int friendB = 1;
    final static int friendshipPoint = 10;
    final static int visitPoint = 1;

    static String user;
    static Map<String, Integer> recommendationPoiont;


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void increaseFriendShipPoint(List<List<String>> friends, List<String> userKnowFriends){
        for(List<String> friendship: friends){
            String recommendationFriend = findFriendKnowFriend(friendship, userKnowFriends);
            if(recommendationFriend != null) {
                increasePoint(recommendationFriend, friendshipPoint);
            }
        }
    }

    public static void increasePoint(String name, int point){
        if(recommendationPoiont.containsKey(name)) {
            int beforePoint = recommendationPoiont.get(name);
            recommendationPoiont.replace(name, beforePoint + point);
        }
        else{
            recommendationPoiont.put(name, point);
        }
    }

    public static String findFriendKnowFriend(List<String> friendship, List<String> userKnowFriends){
        String recommendationFriend = null;
        for(int i = 0; i < 2; i++){
            String friend = friendship.get(i);
            if(userKnowFriends.contains(friend)){
                int recommendationFriendIndex = notOperator(i);
                recommendationFriend = friendship.get(recommendationFriendIndex);
                if(recommendationFriend.equals(user)){
                    recommendationFriend = null;
                }
            }
        }
        return recommendationFriend;
    }

    public static List<String> createUserKnowFriends(List<List<String>> friends, String user){
        List<String> userKnowFriends = new ArrayList<String>();

        for(List<String> friendship: friends){
            if(friendship.contains(user)){
                int userIndex = friendship.indexOf(user);
                int friendIndex = notOperator(userIndex);
                String friend = friendship.get(friendIndex);
                userKnowFriends.add(friend);
            }
        }
        return userKnowFriends;
    }

    public static int notOperator(int friendAorB){
        if(friendAorB == friendA){
            return friendB;
        }
        else if(friendAorB == friendB){
            return friendA;
        }
        else{
            return -1;
        }
    }
}
