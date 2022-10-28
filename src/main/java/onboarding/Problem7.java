package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> recommend = giveVisitScore(visitors,giveFriendsScore(user,friends));
        removeUserAndFriendsInRecommendationFriends(user,friends,recommend);
        return answer;
    }
    private static HashMap<String, Integer> giveFriendsScore(String user, List<List<String>> friends){
        HashMap<String,Integer> recommendationFriends = new HashMap<>();
        for (String friendsOfUser: findUserRelation(user,friends)) {
            recommendationFriends = findFriendsOfUserLoop(friendsOfUser,friends,recommendationFriends);
        }
        return recommendationFriends;
    }
    private static List<String> findUserRelation(String user, List<List<String>> friends){
        List<String> friendsOfUser = new ArrayList<>();
        friends.forEach(relationTwoUsers -> {
            if(relationTwoUsers.contains(user)){
                friendsOfUser.add(relationTwoUsers.get(!(relationTwoUsers.indexOf(user)!=0)?1:0));
            }
        });
        return friendsOfUser;
    }
    private static HashMap<String,Integer> findFriendsOfUserLoop(String friendsOfUser, List<List<String>> friends, HashMap<String, Integer> recommendationFriends) {
        for (String newFriendsOfUser: findUserRelation(friendsOfUser, friends)) {
            giveRecommendationScore(newFriendsOfUser,recommendationFriends,10);
        }
        return recommendationFriends;
    }
    private static void giveRecommendationScore(String newFriendsOfUser, Map<String, Integer> recommendationFriends,Integer score) {
        if(recommendationFriends.get(newFriendsOfUser) != null){
            recommendationFriends.put(newFriendsOfUser,recommendationFriends.get(newFriendsOfUser)+score);
            return;
        }
        recommendationFriends.put(newFriendsOfUser, score);
    }
    private static HashMap<String, Integer> giveVisitScore(List<String> visitors,HashMap<String, Integer> recommendationFriends){
        visitors.forEach(visitor -> giveRecommendationScore(visitor,recommendationFriends,1));
        return recommendationFriends;
    }
    private static HashMap<String,Integer> removeUserAndFriendsInRecommendationFriends(String user, List<List<String>> friends, HashMap<String,Integer> recommend){
        List<String> userAndFriends = createUserAndFriends(user,friends);
        userAndFriends.forEach(userId -> recommend.remove(userId));
        return recommend;
    }
    private static List<String> createUserAndFriends(String user, List<List<String>> friends) {
        List<String> userAndFriends = findUserRelation(user,friends);
        userAndFriends.add(user);
        return userAndFriends;
    }

}
