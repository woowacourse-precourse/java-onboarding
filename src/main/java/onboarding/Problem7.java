package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,List<String>> friendships;
        friendships = setFriendship(friends);
        System.out.println(friendships);
        List<String> answer = Collections.emptyList();
        return answer;

    }

    private static Map<String,List<String>> setFriendship(List<List<String>> friends){
        Map<String,List<String>> friendships = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            List<String> currentFriendships = friends.get(i);
            String currentKey = currentFriendships.get(0);
            String currentValue = currentFriendships.get(1);
            /* 친구 관계는 상호 관계이므로 둘다 관계성 추가 */
            List<String> currentFriendship = getRelationToHash(friendships, currentKey, currentValue);
            friendships.put(currentKey, currentFriendship);
            currentFriendship = getRelationToHash(friendships, currentValue, currentKey);
            friendships.put(currentValue, currentFriendship);
        }
        return friendships;
    }

    private static List<String> getRelationToHash(Map<String,List<String>> friendships, String key, String value){
        List<String> temp = new ArrayList<>();
        if (friendships.get(key) == null){
            temp.add(value);
            return temp;
        }
        temp = friendships.get(key);
        temp.add(value);
        return temp;
    }
}
