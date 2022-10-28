package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> createFriendList(String user, List<List<String>> friends){
        List<String> friendList = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0) == user)
                friendList.add(friends.get(i).get(1));
            else if(friends.get(i).get(1) == user)
                friendList.add(friends.get(i).get(0));
        }

        return friendList;
    }

    private static HashMap<String, Integer> getRecommendPoint(List<String> friendList, List<String> visitorList){
        HashMap<String, Integer> pointMap = new HashMap<>();

        for(int i = 0; i < friendList.size(); i++){
            pointMap.put(friendList.get(i), 10);
        }

        for(int i = 0; i < visitorList.size(); i++){
            if(pointMap.containsKey(visitorList.get(i)))
                pointMap.put(visitorList.get(i), pointMap.get(visitorList.get(i)) + 1);
            else
                pointMap.put(visitorList.get(i), 1);
        }

        return pointMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
