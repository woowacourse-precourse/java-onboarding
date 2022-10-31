package onboarding;

import java.util.*;

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

    public static void initData(String userName){
        recommendationPoiont = new HashMap<String, Integer>();
        user = userName;
    }


    public static void sort(Map<String, Integer> recommendationPoiont){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(recommendationPoiont.entrySet());
        Collections.sort(entryList, new recommendationPointComparator());
    }

    public static void increaseVisitorPoint(List<String> visitors, List<String> userKnowFriend){
        for(String visitorName: visitors){
            if(!userKnowFriend.contains(visitorName))
                increasePoint(visitorName, visitPoint);
        }
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

class recommendationPointComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> c1, Map.Entry<String, Integer> c2){
        if(c1.getValue() > c2.getValue()){
            return 1;
        }
        else if(c1.getValue() < c2.getValue()){
            return -1;
        }
        else{
            return c1.getKey().compareTo(c2.getKey());
        }
    }
}
