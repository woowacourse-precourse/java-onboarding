package onboarding;

import java.util.*;

class ScoredUser {
    private int score;
    private String name;

    ScoredUser(int score, String name) {
        this.score = score;
        this.name = name;
    }

    void plusScore(int plus) {
        this.score += plus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoredUser user = (ScoredUser) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}

public class Problem7 {

    private static final Map<String, Set<String>> followerStorage = new HashMap<>();



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        computeRecommendScore(user, friends, visitors);


    }

    private static void computeRecommendScore(String user, List<List<String>> friends, List<String> visitors) {
        setFollowers(friends);

    }

    private static void setFollowers(List<List<String>> friends) {
        friends.forEach(friendPair -> {
            String username1 = friendPair.get(0);
            String username2 = friendPair.get(1);

            Set<String> followers1 = followerStorage.get(username1);
            Set<String> followers2 = followerStorage.get(username2);

            if (followers1 == null) {
                followers1 = new HashSet<>();
                followerStorage.put(username1, followers1);
            }

            if (followers2 == null) {
                followers2 = new HashSet<>();
                followerStorage.put(username2, followers2);
            }

            followers1.add(username2);
            followers2.add(username1);
        });
    }

}
