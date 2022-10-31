package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();
        Set<String> friend_list = get_friend_list(user, friends);

        visitor_score_check(user, friend_list, score, visitors);
        friend_score_check(user, friend_list, friends, score);
        System.out.println(score);
        System.out.println(score_to_list(score));

        return score_to_list(score);
    }

    public static Set<String> get_friend_list(String user, List<List<String>> friends) {
        Set<String> friend_list = new HashSet<>();
        for (List<String> friend_form : friends) {
            if (friend_form.contains(user)) {
                int index_of_friend = Math.abs(friend_form.indexOf(user) - 1);
                friend_list.add(friend_form.get(index_of_friend));
            }
        }
        return friend_list;
    }

    public static void visitor_score_check(String user, Set<String> friend_list, Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friend_list.contains(visitor) && !friend_list.contains(user)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    public static List<String> score_to_list(Map<String, Integer> score) {
        List<String> recommend_list = new ArrayList<>();
        Set<Integer> scores = new HashSet<>(score.values());
        List<Integer> ordered_score = new ArrayList<>(scores);

        Collections.sort(ordered_score, Collections.reverseOrder());
        for (int n : ordered_score) {
            for (String key : score.keySet()) {
                if (score.get(key) == n) {
                    recommend_list.add(key);
                }
            }
        }

        if (recommend_list.size() > 5)
            return recommend_list.subList(0, 5);
        return recommend_list;
    }

    public static void friend_score_check(String user, Set<String> friend_list, List<List<String>> friends, Map<String, Integer> score) {
        for (List<String> friend_form : friends) {
            for (String friend : friend_list)
                if (friend_form.contains(friend)) {
                    if (!friend_form.contains(user)) {
                        int index_of_friend = Math.abs(friend_form.indexOf(friend) - 1);
                        score.put(friend_form.get(index_of_friend), score.getOrDefault(friend_form.get(index_of_friend), 0) + 10);
                    }
                }
        }
    }
}

