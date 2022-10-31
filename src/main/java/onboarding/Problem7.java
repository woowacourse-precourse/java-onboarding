package onboarding;

import java.util.*;

public class Problem7 {
    public static void getFriendsList(List<List<String>> friends, TreeMap<String, Integer> friendsList) {
        HashSet<String> friendsNameList = new HashSet<>();
        for (int index = 0; index < friends.size(); index++) {
            List<String> friendsPair = friends.get(index);
            friendsNameList.add(friendsPair.get(0));
            friendsNameList.add(friendsPair.get(1));
        }
        for (String friendName : friendsNameList) {
            friendsList.put(friendName, 0);
        }
    }
    public static void getUserFriendsList(String user, List<List<String>> friends, HashSet<String> userFriendsList) {
        for (int index = 0; index < friends.size(); index++) {
            List<String> friendsPair = friends.get(index);
            if (friendsPair.contains(user)) {
                userFriendsList.add(friendsPair.get(0));
                userFriendsList.add(friendsPair.get(1));
            }
        }
        userFriendsList.remove(user);
    }
    public static void addAcquaintancePoints(TreeMap<String, Integer> friendsList, List<List<String>> friends, HashSet<String> userFriendsList) {
        for (String userFriend : userFriendsList) {
            for (int j = 0; j < friends.size(); j++) {
                List<String> friendsPair = friends.get(j);
                String acquaintance = friendsPair.get(0) != userFriend ? friendsPair.get(0) : friendsPair.get(1);
                if (friendsPair.contains(userFriend)) {
                    friendsList.put(acquaintance, friendsList.get(acquaintance) + 10);
                }
            }
        }
    }
    public static void addVisitorsPoints(TreeMap<String, Integer> friendsList, List<String> visitors, HashSet<String> userFriendsList) {
        for (String visitor : visitors) {
            if (userFriendsList.contains(visitor))
                continue;
            if (!friendsList.containsKey(visitor))
                friendsList.put(visitor, 0);
            friendsList.put(visitor, friendsList.get(visitor) + 1);
        }
    }
    public static void getAnswer(String user, TreeMap<String, Integer> friendsList, List<String> answer) {
        friendsList.remove(user);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(String friend : friendsList.keySet()){ //저장된 key값 확인
            hashMap.put(friend, friendsList.get(friend));
        }
        List<String> sortedByPointsList = new ArrayList<>(hashMap.keySet());
        Collections.sort(sortedByPointsList, (value1, value2) -> (hashMap.get(value2).compareTo(hashMap.get(value1))));

        int count = 0;
        for(String key : sortedByPointsList) {
            if (hashMap.get(key) == 0)
                break;
            answer.add(key);
            count++;
            if (count == 5)
                return;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        TreeMap<String, Integer> friendsList = new TreeMap<>();
        getFriendsList(friends, friendsList);
        HashSet<String> userFriendsList = new HashSet<>();
        getUserFriendsList(user, friends, userFriendsList);
        addAcquaintancePoints(friendsList, friends, userFriendsList);
        addVisitorsPoints(friendsList, visitors, userFriendsList);
        List<String> answer = new ArrayList<>();
        getAnswer(user, friendsList, answer);
        return answer;
    }
}
