package onboarding;

import java.util.*;

public class Problem7 {

    /*
    모든 사용자의 친구 리스트 만들기
     */
    static Map<String, Set<String>> findFriends(List<List<String>> friends){
        Map<String, Set<String>> friendsList = new HashMap<>();
        for(int idx = 0; idx < friends.size(); idx++){
            String user1Name = friends.get(idx).get(0);
            String user2Name = friends.get(idx).get(1);
            Set<String> curFriendsList;
            //user1
            if(friendsList.containsKey(user1Name)){
                curFriendsList = friendsList.get(user1Name);
                curFriendsList.add(user2Name);
            }
            else{
                Set<String> newFriendList = new HashSet<>();
                newFriendList.add(user2Name);
                friendsList.put(user1Name, newFriendList);
            }
            //user2
            if(friendsList.containsKey(user2Name)){
                curFriendsList = friendsList.get(user2Name);
                curFriendsList.add(user1Name);
            }
            else{
                Set<String> newFriendList = new HashSet<>();
                newFriendList.add(user1Name);
                friendsList.put(user2Name, newFriendList);
            }
        }
        return friendsList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }
}
