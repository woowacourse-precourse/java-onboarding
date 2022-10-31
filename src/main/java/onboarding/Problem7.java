package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> recommend = giveVisitScore(visitors, giveFriendsScore(user, friends));
        removeUserAndFriendsInRecommendationFriends(user, friends, recommend);
        List<Map.Entry<String, Integer>> recommends = sortRecommendationFriends(recommend);
        List<String> answer = fiveRecommendFriends(recommends);
        return answer;
    }

    private static HashMap<String, Integer> giveFriendsScore(String user, List<List<String>> friends) {
        HashMap<String, Integer> recommendationFriends = new HashMap<>();
        for (String friendsOfUser : findUserRelation(user, friends)) {
            recommendationFriends = findFriendsOfUserLoop(friendsOfUser, friends, recommendationFriends);
        }
        return recommendationFriends;
    }

    private static List<String> findUserRelation(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();
        friends.forEach(relationTwoUsers -> {
            if (relationTwoUsers.contains(user)) {
                friendsOfUser.add(relationTwoUsers.get(!(relationTwoUsers.indexOf(user) != 0) ? 1 : 0));
            }
        });
        return friendsOfUser;
    }

    private static HashMap<String, Integer> findFriendsOfUserLoop(String friendsOfUser, List<List<String>> friends, HashMap<String, Integer> recommendationFriends) {
        for (String newFriendsOfUser : findUserRelation(friendsOfUser, friends)) {
            giveRecommendationScore(newFriendsOfUser, recommendationFriends, 10);
        }
        return recommendationFriends;
    }

    private static void giveRecommendationScore(String newFriendsOfUser, Map<String, Integer> recommendationFriends, Integer score) {
        if (recommendationFriends.get(newFriendsOfUser) != null) {
            recommendationFriends.put(newFriendsOfUser, recommendationFriends.get(newFriendsOfUser) + score);
            return;
        }
        recommendationFriends.put(newFriendsOfUser, score);
    }

    private static HashMap<String, Integer> giveVisitScore(List<String> visitors, HashMap<String, Integer> recommendationFriends) {
        visitors.forEach(visitor -> giveRecommendationScore(visitor, recommendationFriends, 1));
        return recommendationFriends;
    }

    private static HashMap<String, Integer> removeUserAndFriendsInRecommendationFriends(String user, List<List<String>> friends, HashMap<String, Integer> recommend) {
        List<String> userAndFriends = createUserAndFriends(user, friends);
        userAndFriends.forEach(userId -> recommend.remove(userId));
        return recommend;
    }

    private static List<String> createUserAndFriends(String user, List<List<String>> friends) {
        List<String> userAndFriends = findUserRelation(user, friends);
        userAndFriends.add(user);
        return userAndFriends;
    }

    private static List<Map.Entry<String, Integer>> sortRecommendationFriends(HashMap<String, Integer> recommend) {
        return recommend.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue() - o1.getValue();
                })
                .collect(Collectors.toList());
    }

    private static List<String> fiveRecommendFriends(List<Map.Entry<String, Integer>> recommends) {
        List<String> recommend = new ArrayList<>();
        for (int i = 0; i < recommends.size(); i++) {
            if (i == 5) break;
            recommend.add(recommends.get(i).getKey());
        }
        return recommend;
    }
}
