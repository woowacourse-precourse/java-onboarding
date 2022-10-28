package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Problem7 {
    public static class Score {
        String username;
        int score;

        public Score(String username, int score) {
            this.username = username;
            this.score = score;
        }

        public void addScore1() {
            this.score += 1;
        }

        public void addScore10() {
            this.score += 10;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        getFriendsHashMap(friends);
        PriorityQueue<Score> scorePriorityQueue = getScorePriorityQueue();
        return answer;
    }

    public static HashMap<String, ArrayList<String>> getFriendsHashMap(List<List<String>> friendsList) {
        HashMap<String, ArrayList<String>> friendsHashMap = new HashMap<>();
        for (List<String> friend : friendsList) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            putUserRelation(friendsHashMap, user1, user2);
            putUserRelation(friendsHashMap, user2, user1);
        }
        return friendsHashMap;
    }

    public static void putUserRelation(HashMap<String, ArrayList<String>> friendsHashMap, String user1, String user2) {
        if (!friendsHashMap.containsKey(user1)) {
            friendsHashMap.put(user1, new ArrayList<>(List.of(user2)));
            return;
        }
        friendsHashMap.get(user1).add(user2);
    }

    public static PriorityQueue<Score> getScorePriorityQueue() {
        return new PriorityQueue<>((a, b) -> (a.score == b.score) ?
                                            a.username.compareTo(b.username) : b.score-a.score);
    }
}
