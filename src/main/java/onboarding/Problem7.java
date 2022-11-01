package onboarding;

import java.util.*;

public class Problem7 {
    //user에 따라 친구 목록을 만드는 map
    public static Map<String, List<String>> getUsersList(List<List<String>> friends){
        Map<String, List<String>> userFriendsList = new HashMap<>();
        for (List<String> friend : friends) {
            if (!userFriendsList.containsKey(friend.get(0)))
                userFriendsList.put(friend.get(0), new ArrayList<>());
            if (!userFriendsList.containsKey(friend.get(1)))
                userFriendsList.put(friend.get(1), new ArrayList<>());
            userFriendsList.get(friend.get(0)).add(friend.get(1));
            userFriendsList.get(friend.get(1)).add(friend.get(0));
        }
        return userFriendsList;
    }
    // 친구 목록에 따라 주어지는 포인트를 map<친구이름, 점수>로 저장하는 함수
    public static Map<String, Integer> getUsersPoint(String user, Map<String, List<String>> usersFriendsMap, List<String> visitors){
        Map<String, Integer> usersPoint = new HashMap<>();
        for(String userName : usersFriendsMap.keySet()) {
            usersPoint.put(userName, 0);
        }
        List<String> userOfFriend = new ArrayList<>();
        userOfFriend.addAll(usersFriendsMap.get(user));
        for (String key : userOfFriend) {
            for (int j = 0; j < usersFriendsMap.get(key).size(); j++) {
                if (!usersFriendsMap.get(key).get(j).equals(user))
                    usersPoint.put(usersFriendsMap.get(key).get(j), usersPoint.get(usersFriendsMap.get(key).get(j)) + 10);
            }
        }
        Set<String> userFriends = new HashSet<>();
        userFriends.addAll(usersFriendsMap.get(user));
        for(String visitorInfo : visitors){
            if (userFriends.contains(visitorInfo))
                continue ;
            else if (usersPoint.containsKey(visitorInfo))
                usersPoint.put(visitorInfo, usersPoint.get(visitorInfo) + 1);
            else
                usersPoint.put(visitorInfo, 1);
        }
        return usersPoint;
    }
    //점수와 이름의 순서대로 정렬하는 함수
    public static List<String>  sortValueMap(String user, Map<String, Integer> allUsersPoints){
        List<List<String>> sortingList = new ArrayList<>();

        Set<String> keySet = allUsersPoints.keySet();
        for (String key : keySet) {
            if (allUsersPoints.get(key) == 0) continue;
            if (key.equals(user)) continue;
            List<String> temp = new ArrayList<>();
            temp.add(key);
            temp.add(String.valueOf(allUsersPoints.get(key)));
            sortingList.add(temp);
        }
        Collections.sort(sortingList, new recommendationSort<>());
        System.out.println(sortingList);
        List<String> result = new ArrayList<>();
        for (List<String> strings : sortingList) {
            result.add(strings.get(0));
            if (result.size() >= 5)
                break;
        }
        return result;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
