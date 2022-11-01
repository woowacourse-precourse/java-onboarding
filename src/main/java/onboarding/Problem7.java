package onboarding;

import java.util.*;

public class Problem7 {
    private static void visitorScoreCheck(String user, Set<String> friendList, Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendList.contains(visitor) && !friendList.contains(user)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    private static List<String> scoreList(Map<String, Integer> score) {
        List<String> recommendList = new ArrayList<>();
        Set<Integer> scores = new HashSet<>(score.values());
        List<Integer> orderedScore = new ArrayList<>(scores);

        Collections.sort(orderedScore, Collections.reverseOrder());
        for (int n : orderedScore) {
            for (String key : score.keySet()) {
                if (score.get(key) == n) {
                    recommendList.add(key);
                }
            }
        }

        if (recommendList.size() > 5)
            return recommendList.subList(0, 5);
        return recommendList;
    }

    private static void friendScoreCheck(String user, Set<String> friendList, List<List<String>> friends, Map<String, Integer> score) {
        for (List<String> friendForm : friends) {
            for (String friend : friendList)
                if (friendForm.contains(friend)) {
                    if (!friendForm.contains(user)) {
                        int index_of_friend = Math.abs(friendForm.indexOf(friend) - 1);
                        score.put(friendForm.get(index_of_friend), score.getOrDefault(friendForm.get(index_of_friend), 0) + 10);
                    }
                }
        }
    }
    private static Set<String> getRelations(String user, List<List<String>> friends) {
        Set<String> friend_list = new HashSet<>();
        for (List<String> friend_form : friends) {
            if (friend_form.contains(user)) {
                int index_of_friend = Math.abs(friend_form.indexOf(user) - 1);
                friend_list.add(friend_form.get(index_of_friend));
            }
        }
        return friend_list;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors){
        Map<String, Integer> scoreTable = new HashMap<>();
        Set<String> friendList = getRelations(user, friends);

        visitorScoreCheck(user, friendList, scoreTable, visitors);
        friendScoreCheck(user, friendList, friends, scoreTable);

        return scoreList(scoreTable);
    }

}
