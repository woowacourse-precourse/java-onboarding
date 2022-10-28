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

    private static List<String> createFriendsFriendList(List<String> friendList, List<List<String>> friends){
        List<String> friendsFriendList = new ArrayList<>();

        for(int i = 0; i < friendList.size(); i++){
            for(int j = 0; j < friends.size(); j++){
                if(friendList.get(i) == friends.get(j).get(0))
                    friendsFriendList.add(friends.get(i).get(1));
                else if(friendList.get(i) == friends.get(j).get(1))
                    friendsFriendList.add(friends.get(i).get(0));
            }
        }

        return friendsFriendList;
    }

    private static HashMap<String, Integer> getRecommendPoint(List<String> friendList, List<String> ffList, List<String> visitorList){
        HashMap<String, Integer> pointMap = new HashMap<>();

        for(int i = 0; i < ffList.size(); i++){
            if(pointMap.containsKey(ffList.get(i)))
                pointMap.put(ffList.get(i), pointMap.get(ffList.get(i)) + 10);
            else
                pointMap.put(ffList.get(i), 10);
        }

        for(int i = 0; i < visitorList.size(); i++){
            if(pointMap.containsKey(visitorList.get(i)))
                pointMap.put(visitorList.get(i), pointMap.get(visitorList.get(i)) + 1);
            else
                pointMap.put(visitorList.get(i), 1);
        }

        for(int i = 0; i < friendList.size(); i++){
            if(pointMap.containsKey(friendList.get(i)))
                pointMap.remove(friendList.get(i));
        }

        return pointMap;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendList = createFriendList(user, friends);
        List<String> ffList = createFriendsFriendList(friendList, friends);
        HashMap<String, Integer> pointMap = getRecommendPoint(friendList, ffList, visitors);

        List<Map.Entry<String, Integer>> sortedPointList = new ArrayList<>(pointMap.entrySet());
        sortedPointList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        sortedPointList.forEach(System.out::println);

        for(int i = 0; i < sortedPointList.size(); i++) {
            if (pointMap.get(sortedPointList.get(i).getKey()) != 0 && answer.size() < 5)
                answer.add(Objects.toString(sortedPointList.get(i).getKey()));
            else
                break;
        }

        return answer;
    }
}
