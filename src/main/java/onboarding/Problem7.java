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

    public static void calculateVisitors(List<String> visitors,List<String> userFriends, HashMap<String, Integer> hashMap){
        for (String visitor: visitors) {
            if (!userFriends.contains(visitor)){
                updateScore(hashMap,1,visitor);
            }
        }
    }

    public static List<String> sortScore(HashMap<String, Integer> hashMap){
        List<Map.Entry<String, Integer> > hashEntry =
                new LinkedList<>(hashMap.entrySet());

        hashEntry.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return (o2.getValue()).compareTo(o1.getValue());
        });

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < Math.min(hashEntry.size(), 5); i++) {
            answer.add(hashEntry.get(i).getKey());
        }
        return answer;
    }
}
