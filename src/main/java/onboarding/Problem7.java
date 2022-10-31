package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findUserFriends(String user, List<List<String>> friends){

        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (Objects.equals(friend.get(0), user)) {
                userFriends.add(friend.get(1));
            }
            if (Objects.equals(friend.get(1), user)) {
                userFriends.add(friend.get(0));
            }
        }

        return userFriends;
    }

    public static void updateScore(HashMap<String, Integer> hashMap, int score, String userName) {

        if (hashMap.containsKey(userName)) {
            hashMap.put(userName, hashMap.get(userName) + score);
        } else {
            hashMap.put(userName, score);
        }

    }

    public static void calculateFriendsScore(List<List<String>> friends, List<String> userFriends ,HashMap<String, Integer> hashMap, String user){
        for (List<String> friend : friends) {
            if (!Objects.equals(friend.get(0), user) && !Objects.equals(friend.get(1), user)) {
                if (userFriends.contains(friend.get(0))){
                    updateScore(hashMap,10,friend.get(1));
                }
                if (userFriends.contains(friend.get(1))){
                    updateScore(hashMap,10,friend.get(0));
                }
            }
        }
    }
}
