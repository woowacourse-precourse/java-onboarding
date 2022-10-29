package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendList = new HashMap<>();

        Map<String, Integer> friendList = getFriend(user, friends);
        for (List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);

            if (friendList.containsKey(friend1)){
                recommendList.merge(friend2, 10, (point, b) -> point += 10);
            }
            else if (friendList.containsKey(friend2)){
                recommendList.merge(friend1, 10, (point, b) -> point += 10);
            }
        }

        for (String visitor : visitors){
            recommendList.merge(visitor, 1, (point, b) -> point += 1);
        }

        recommendList.remove(user);
        friendList.forEach((friendName, friendPoint) -> recommendList.remove(friendName));

        List<String> answer = new ArrayList<>(recommendList.keySet());
        answer.sort(((o1, o2) -> {
            int sortNum = recommendList.get(o2) - recommendList.get(o1);
            if (sortNum == 0){
                return o1.compareTo(o2);
            }
            return sortNum;
        }));

        int answerSize = Math.min(answer.size(), 5);
        answer = answer.subList(0, answerSize);
        return answer;
    }

    private static Map<String, Integer> getFriend(String user, List<List<String>> friends){
        Map<String, Integer> userFriend = new HashMap<>();
        for (List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);

            if (user.equals(friend1))
                userFriend.put(friend2, 10);
            else if (user.equals(friend2))
                userFriend.put(friend1, 10);
        }

        return userFriend;
    }

}
