package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
    private static void findFriendsOfUser(String user, List<List<String>> friends){
        findUserRelation(user,friends).forEach(friendsOfUser -> {
            HashMap<String,Integer> recommendationFriends = findFriendsOfUserLoop(friendsOfUser,friends);
        });
    }
    private static HashMap<String,Integer> findFriendsOfUserLoop(String friendsOfUser, List<List<String>> friends) {
        Map<String,Integer> recommendationFriends = new HashMap<>();
        for (String newFriendsOfUser: findUserRelation(friendsOfUser, friends)) {
            giveRecommendationScore(newFriendsOfUser,recommendationFriends);
        }
        return (HashMap<String, Integer>) recommendationFriends;
    }
    private static void giveRecommendationScore(String newFriendsOfUser, Map<String, Integer> recommendationFriends) {
            if(recommendationFriends.get(newFriendsOfUser) != null){
                recommendationFriends.put(newFriendsOfUser,recommendationFriends.get(newFriendsOfUser)+10);
                return;
            }
            recommendationFriends.put(newFriendsOfUser, 10);
    }

}
