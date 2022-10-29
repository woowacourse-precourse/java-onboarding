package onboarding;

import java.util.*;

class RecommendedFriend implements Comparable<RecommendedFriend> {

    private String name;
    private int score;

    public RecommendedFriend(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    @Override
    public int compareTo(RecommendedFriend other) {
        if (this.score < other.score) {
            return -1;
        } else if (this.score == other.score) {
            if (this.name.compareTo(other.name) > 0) {
                return -1;
            }
        }
        return 1;
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendList = createFriendList(friends);
        return null;
    }

    private static Map<String, List<String>> createFriendList(List<List<String>> friends) {
        Map<String, List<String>> result = new HashMap<>();
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            List<String> userAFriends = result.getOrDefault(userA, new ArrayList<>());
            userAFriends.add(userB);
            result.put(userA, userAFriends);

            List<String> userBFriends = result.getOrDefault(userB, new ArrayList<>());
            userBFriends.add(userA);
            result.put(userB, userBFriends);
        }
        return result;
    }
}
