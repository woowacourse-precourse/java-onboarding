package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FriendRecommendation implements Comparable<FriendRecommendation> {
    String name;
    int score;

    public FriendRecommendation(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(FriendRecommendation o) {
        if (this.score == o.score) return this.name.compareTo(o.name);
        return o.score - this.score;
    }
}

public class Problem7 {
    static String mainUser;
    static HashMap<String, String> friendsOfUser = new HashMap<>();
    static HashMap<String, Integer> scoreOfUser = new HashMap<>();

    public static String[] getFriends(String user) {
        String friendString = friendsOfUser.get(user);

        return friendString.split("/");
    }

    public static void addScoreByRelation() {
        String[] friendArr = getFriends(mainUser);
        for (String friend : friendArr) {
            String[] friendOfFriendArr = getFriends(friend);
            for (String friendOfFriend : friendOfFriendArr) {
                scoreOfUser.put(friendOfFriend, scoreOfUser.getOrDefault(friendOfFriend, 0) + 10);
            }
        }
    }

    public static void addScoreByVisit(List<String> visitors) {
        for (String visitor : visitors) {
            scoreOfUser.put(visitor, scoreOfUser.getOrDefault(visitor, 0) + 1);
        }
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        mainUser = user;

        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            friendsOfUser.put(user1, friendsOfUser.getOrDefault(user1, "") + user2 + "/");
            friendsOfUser.put(user2, friendsOfUser.getOrDefault(user2, "") + user1 + "/");
        }

        addScoreByRelation();
        addScoreByVisit(visitors);

        List<FriendRecommendation> friendRecommendations = new ArrayList<>();
        for (Map.Entry recommendedFriend : scoreOfUser.entrySet()) {
            String name = (String) recommendedFriend.getKey();
            int score = (int) recommendedFriend.getValue();
            FriendRecommendation friendRecommendation = new FriendRecommendation(name, score);

            friendRecommendations.add(friendRecommendation);
        }

        for (FriendRecommendation fr : friendRecommendations) {
            System.out.println(fr.name + " " + fr.score);
        }

        return List.of("Test");
    }
}
