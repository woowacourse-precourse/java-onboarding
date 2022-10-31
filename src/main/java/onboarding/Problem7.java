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
    private static final Map<String, ScoredUser> scoredUserStorage = new HashMap<>();
    private static final Map<String, Set<String>> followerStorage = new HashMap<>();

    private static final SortedSet<ScoredUser> scoreBoard = new TreeSet<>(new scoreBoardComparator());

    private static class scoreBoardComparator implements Comparator<ScoredUser> {
        @Override
        public int compare(ScoredUser o1, ScoredUser o2) {
            if (o1.getScore() == o2.getScore()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o2.getScore() - o1.getScore();
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        computeRecommendScore(user, friends, visitors);

        ScoredUser[] rankBoard = scoreBoard.toArray(new ScoredUser[5]);
        List<String> result = new ArrayList<>(5);

        for (ScoredUser scoredUser : rankBoard) {
            if (scoredUser == null) {
                break;
            }
            result.add(scoredUser.getName());
        }

        return result;
    }

    private static void computeRecommendScore(String user, List<List<String>> friends, List<String> visitors) {
        setFollowers(friends);

        Set<String> myFollowers = followerStorage.get(user);

        myFollowers.forEach(follower -> {
            Set<String> followersOfFollower = followerStorage.get(follower);

            followersOfFollower.forEach(followerOfFollower -> {
                if (!followerOfFollower.equals(user) && !myFollowers.contains(followerOfFollower)) {
                    addScore(followerOfFollower, 10);
                }
            });
        });

        visitors.forEach(visitorName -> {
            if (!visitorName.equals(user) && !myFollowers.contains(visitorName)) {
                addScore(visitorName, 1);
            }
        });
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

    private static void addScore(String username, int score) {
        ScoredUser scoredUser = scoredUserStorage.get(username);

        if (scoredUser == null) {
            scoredUser = new ScoredUser(0, username);
            scoredUserStorage.put(scoredUser.getName(), scoredUser);
        }

        scoredUser.plusScore(score);
        scoreBoard.add(scoredUser);
    }
}
