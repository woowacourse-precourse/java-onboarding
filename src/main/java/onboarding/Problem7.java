package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String,List<String>> friendships;
        friendships = setFriendship(friends);
        System.out.println(friendships);

        List<String> friendsFriends = getFriendsFriends(user, friendships);
        System.out.println(friendsFriends);

        Map<String, Integer> score = getRelationScore(friendsFriends);
        System.out.println(score);


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

    private static List<String> getFriendsFriends(String user, Map<String,List<String>> friendships){
        List<String> temp = new ArrayList<>();
        List<String> userFriend = friendships.get(user);
        for (int i = 0; i < userFriend.size(); i++) {
            List<String> currentFriendsFriends = friendships.get(userFriend.get(i));
            for (int j = 0; j < currentFriendsFriends.size(); j++) {
                temp.add(currentFriendsFriends.get(i));
            }
        }
        return temp;
    }

    private static Map<String, Integer> getRelationScore(List<String> friendsFriends){
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < friendsFriends.size(); i++) {
            String key = friendsFriends.get(i);
            System.out.println(temp.containsKey(key));
            if (temp.containsKey(key)){
                temp.put(key, temp.get(key) + 10);
            }
            else{
                temp.put(key, 10);
            }
        }
        return temp;
    }
}
