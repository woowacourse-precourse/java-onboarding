package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * user의 친구들을 반환하는 함수
     */
    private static List<String> userFriends(String user, List<List<String>> friends){
        List<String> userFriendList = Collections.emptyList();
        for (int i=0;i<friends.size();i++){
            userFriendList = isUserFriend(user,friends.get(i),userFriendList);
        }
        return userFriendList;
    }

    /**
     * user의 친구를 찾아주는 함수
     */
    private static List<String> isUserFriend(String user, List<String> friend,List<String> userFriendList){
        if (friend.contains(user)){
            int friendIndex = (friend.indexOf(user) + 1)%2;
            userFriendList.add(friend.get(friendIndex));
        }
        return userFriendList;
    }

    /**
     * friends의 사람들을 Map에 저장하는 함수
     */
    private static Map<String,Integer> listToMap(List<List<String>> friends){
        Map<String, Integer> friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            friendsMap.put(friend.get(0),0);
            friendsMap.put(friend.get(1),0);
        }
        return friendsMap;
    }
}
