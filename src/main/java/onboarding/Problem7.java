package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, List<String>> friendsMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void initFriendsMap(List<List<String>> friends){
        friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            //  first에 second 추가하기
            if(friendsMap.containsKey(firstFriend)){
                friendsMap.get(firstFriend).add(secondFriend);
            }
            else{
                List<String> friendsList = new ArrayList<>();
                friendsList.add(secondFriend);
                friendsMap.put(firstFriend, friendsList);
            }
            // second에 first 추가하기
            if(friendsMap.containsKey(secondFriend)){
                friendsMap.get(secondFriend).add(firstFriend);
            }
            else{
                List<String> friendsList = new ArrayList<>();
                friendsList.add(firstFriend);
                friendsMap.put(secondFriend, friendsList);
            }
        }
    }
}
