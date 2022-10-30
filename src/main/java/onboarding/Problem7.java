package onboarding;

import java.util.*;

public class Problem7 {

    Map<String, Integer> user_score = new HashMap<>();
    Map<String, List<String>> user_friends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // List<String> answer = Collections.emptyList();
        Problem7 problem7 = new Problem7();
        List<String> answer = problem7.returnResult(user, friends, visitors);
        return answer;
    }

    List<String> returnResult(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        setVisitorScore(visitors);
        setFriendScore(user, friends);
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(user_score.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(int i=0; i<5; i++) {
            int score = entryList.get(i).getValue();
            if (score <= 0) {
                continue;
            }
            result.add(entryList.get(i).getKey());
        }
        return result.subList(0,3);
    }


    void setVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (user_score.containsKey(visitor)) {
                user_score.put(visitor, user_score.get(visitor) + 1);
            } else {user_score.put(visitor, 1);}
        }
    }

    void setFriendScore(String user, List<List<String>> friends) {
        setUserFriends(friends);
        System.out.println(user_friends);
        List<String> friends_list = user_friends.get(user);
        for (String friend : friends_list) {
            List<String> f2f_list = user_friends.get(friend);
            for (String f2f : f2f_list) {
                if (f2f.equals(user)) {
                    continue;
                }
                if (user_score.containsKey(f2f)) {
                    user_score.put(f2f, user_score.get(f2f) + 10);
                } else {user_score.put(f2f, 10);}
            }
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
