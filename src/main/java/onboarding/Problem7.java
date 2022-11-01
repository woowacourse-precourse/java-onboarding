package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Recommendation rec = new Recommendation(user, friends, visitors);
        List<String> answer = rec.returnResult();
        return answer;
    }
}

class Recommendation {
    final String user;
    final List<List<String>> friends;
    final List<String> visitors;
    final Map<String, List<String>> friends_map;

    Recommendation(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
        this.friends_map = makeFriendsMap(friends);
    }

    List<String> returnResult() {
        List<String> result = new ArrayList<>();
        Map<String, Integer> friend_score = setFriendScore();
        Map<String, Integer> visitor_score = setVisitorScore(friend_score);
        Map<String, Integer> user_score = setUserScore(visitor_score);
        Map<String, Integer> fltr_user_score = filterUserScore(user_score);
        List<Map.Entry<String, Integer>> sorted_user_entryList = sortUserScore(fltr_user_score);
        int i = 0;
        while (i < 5 & i < sorted_user_entryList.size()) {
            result.add(sorted_user_entryList.get(i).getKey());
            i += 1;
        }
        return result;
    }

    private List<Map.Entry<String, Integer>> sortUserScore(Map<String, Integer> user_score) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(user_score.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList;
    }

    private Map<String, Integer> filterUserScore(Map<String, Integer> user_score) {
        for (String key : user_score.keySet()) {
            if (user_score.get(key) == 0) {
                user_score.remove(key);
            }
        }
        return user_score;
    }

    private Map<String, Integer> setUserScore(Map<String, Integer> user_score) {
        // user key에 대한 친구 목록이 없는 경우 빈 array 반환
        List<String> array = new ArrayList<>();
        List<String> user_friends = friends_map.getOrDefault(user, array);
        for (String friend : user_friends) {
            user_score.remove(friend);
        }
        return user_score;
    }

    private Map<String, Integer> setVisitorScore(Map<String, Integer> user_score) {
        for (String visitor : visitors) {
            user_score.put(visitor, user_score.getOrDefault(visitor, 0) + 1);
        }
        return user_score;
    }

    private Map<String, Integer> setFriendScore() {
        Map<String, Integer> user_score = new HashMap<>();
        // user key에 대한 친구 목록이 없는 경우 빈 array 반환
        List<String> array = new ArrayList<>();
        List<String> friend_list = friends_map.getOrDefault(user, array);
        for (String friend : friend_list) {
            List<String> cross_friend_list = friends_map.get(friend);
            for (String cross_friend : cross_friend_list) {
                if (cross_friend.equals(user)) {
                    continue;
                }
                user_score.put(cross_friend, user_score.getOrDefault(cross_friend, 0) + 10);
            }
        }
        return user_score;
    }

    private Map<String, List<String>> makeFriendsMap(List<List<String>> friends) {
        Map<String, List<String>> friends_map = new HashMap<>();
        for (List<String> friend_list : friends) {
            for (int i = 0; i <= 1; i++) {
                String friend1 = friend_list.get(i);
                String friend2 = friend_list.get(1 - i);
                List<String> array = new ArrayList<>();
                List<String> friend1_friend_list = friends_map.getOrDefault(friend1, array);
                friend1_friend_list.add(friend2);
                friends_map.put(friend1, friend1_friend_list);
            }
        }
        return friends_map;
    }
}
