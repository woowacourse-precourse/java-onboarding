package onboarding;

import java.util.*;

public class Problem7 {

    Map<String, Integer> user_score = new HashMap<>();
    Map<String, List<String>> user_friends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    void setVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (user_score.containsKey(visitor)) {
                user_score.put(visitor, user_score.get(visitor) + 1);
            } else {user_score.put(visitor, 1);}
        }
    }


    void setUserFriends(List<List<String>> friends) {
        for (List<String> friend_list : friends) {
            String friend1 = friend_list.get(0);
            String friend2 = friend_list.get(1);
            if (user_friends.containsKey(friend1)) {
                List<String> array = user_friends.get(friend1);
                array.add(friend2);
                user_friends.put(friend1, array);
            } else {
                ArrayList<String> array = new ArrayList<>();
                array.add(friend2);
                user_friends.put(friend1, array);
            }
            if (user_friends.containsKey(friend2)) {
                List<String> array = user_friends.get(friend2);
                array.add(friend1);
                user_friends.put(friend2, array);
            } else {
                ArrayList<String> array = new ArrayList<>();
                array.add(friend1);
                user_friends.put(friend2, array);
            }
        }
    }
}
