package onboarding;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    // 유저 친구 맵
    public static HashMap<String, ArrayList<String>> createFriendsMap(List<List<String>> friends){
        HashMap<String, ArrayList<String>> friendsList = new HashMap<>();
        for (List<String> friend: friends) {
            for (int i = 0; i < 2; i++) {
                if (!friendsList.containsKey(friend.get(i))){
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(friend.get((i+1)%2));
                    friendsList.put(friend.get(i), temp);
                } else {
                    friendsList.get(friend.get(i)).add(friend.get((i + 1) % 2));
                }
            }
        }
        return friendsList;
    }

    public static HashMap<String, Integer> createUserFriendsMap(String user, HashMap<String, ArrayList<String>> friendsMap){
        HashMap<String, Integer> result = new HashMap<>();

        for (String friend : friendsMap.get(user)) {
            for (String friendOfFriend: friendsMap.get(friend)) {
                if (user.equals(friendOfFriend) || friendsMap.get(user).contains(friendOfFriend)){
                    continue;
                }
                if (!result.containsKey(friendOfFriend)) {
                    result.put(friendOfFriend, 1);
                } else {
                    result.put(friendOfFriend, result.get(friendOfFriend) + 1);
                }
            }                
        }
        return result;
    }

    public static HashMap<String, Integer> calFriendsPoint(HashMap<String, Integer> userFriendsMap, HashMap<String, Integer> pointResult){
        for (Map.Entry<String, Integer> friend : userFriendsMap.entrySet()){
            pointResult.put(friend.getKey(), friend.getValue() * 10);
        }
        return pointResult;
    }

    public static void calVisitorPoint(List<String> visitors, HashMap<String, Integer> pointResult, String user, HashMap<String, ArrayList<String>> friendsMap){
        for (String visitor: visitors) {
            if (friendsMap.get(user).contains(visitor)){
                continue;
            }
            if (!pointResult.containsKey(visitor)){
                pointResult.put(visitor, 1);
            } else {
                pointResult.put(visitor, pointResult.get(visitor) + 1);
            }
        }
    }

    public static List<String> sorting(HashMap<String, Integer> points) {
        // 1. 점수가 가장 높은 순
        // 2. 점수가 같으면 이름순

        return points.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                })
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, ArrayList<String>> friendsMap = createFriendsMap(friends);
        HashMap<String, Integer> userFriendsMap = createUserFriendsMap(user, friendsMap);

        HashMap<String, Integer> friendPoint = calFriendsPoint(userFriendsMap, total);
        calVisitorPoint(visitors, friendPoint, user, friendsMap);

        return sorting(friendPoint);
    }
}
