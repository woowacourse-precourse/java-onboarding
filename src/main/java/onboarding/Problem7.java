package onboarding;

import java.util.*;

class User implements Comparable<User> {

    private final String name;
    private Set<User> friends;
    private int score = 0;
    private int visitCount = 0;
    private int acquaintanceCount = 0;

    public User(String name) {
        this.name = name;
    }

    public void addFriend(User user) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(user);
    }

    public void setAcquaintanceCount(User user) {
        if (friends == null) {
            return;
        }
        for (User friend : friends) {
            acquaintanceCount += getMatchingCount(friend, user);
        }
    }

    public int getMatchingCount(User friend, User user) {
        if (user.isContains(friend)) {
            return 1;
        }
        return 0;
    }

    public boolean isContains(User user) {
        return friends.contains(user);
    }

    public void addVisitCount() {
        visitCount++;
    }

    public void calculateVisitScore(final int visitScore) {
        score += (visitCount * visitScore);
    }

    public void calculateAcquaintanceScore(final int acquaintanceScore) {
        score += (acquaintanceCount * acquaintanceScore);
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User user) {
        int scoreGap = user.getScore() - this.score;
        if (scoreGap == 0) {
            return this.name.compareTo(user.getName());
        }
        return scoreGap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return score == user.score && visitCount == user.visitCount
            && acquaintanceCount == user.acquaintanceCount && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, visitCount, acquaintanceCount);
    }
}

public class Problem7 {

    private static final int VISIT_SCORE = 1;
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int RECOMMEND_COUNT_UPPER_BOUND = 5;
    private static final int RECOMMEND_SCORE_LOWER_BOUND = 0;
    private static Map<String, User> friendGraph;

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        initFriendGraph(friends);
        initFriendGraphWithVisitors(visitors);

        User targetUser = removeTargetUserAndAlreadyFriendsFromGraph(user);

        addVisitCount(visitors);

        ArrayList<User> candidates = new ArrayList<>(friendGraph.values());
        setAcquaintanceCount(candidates, targetUser);

        setScore(candidates);

        return getRecommendList(candidates);
    }


    private static void initFriendGraph(List<List<String>> friends) {
        friendGraph = new HashMap<>();
        User userA, userB;
        for (List<String> twoFriends : friends) {
            userA = addUser(twoFriends.get(0));
            userB = addUser(twoFriends.get(1));
            addFriend(userA, userB);
            addFriend(userB, userA);
        }
    }

    private static User addUser(String userName) {
        if (!friendGraph.containsKey(userName)) {
            friendGraph.put(userName, new User(userName));
        }
        return friendGraph.get(userName);
    }

    private static void addFriend(User user, User friend) {
        user.addFriend(friend);
    }

    private static void initFriendGraphWithVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            addUser(visitor);
        }
    }

    private static User removeTargetUserAndAlreadyFriendsFromGraph(String userName) {
        User targetUser = friendGraph.get(userName);
        User friend;

        friendGraph.remove(userName);

        for (Iterator<Map.Entry<String, User>> it = friendGraph.entrySet().iterator();
            it.hasNext(); ) {
            friend = it.next().getValue();
            if (targetUser.isContains(friend)) {
                it.remove();
            }
        }

        return targetUser;
    }

    private static void addVisitCount(List<String> visitors) {
        for (String visitorName : visitors) {
            addVisitCount(visitorName);
        }
    }

    private static void addVisitCount(String visitorName) {
        if (friendGraph.containsKey(visitorName)) {
            friendGraph.get(visitorName).addVisitCount();
        }
    }

    private static void setAcquaintanceCount(List<User> candidates, User targetUser) {
        candidates.forEach(u -> u.setAcquaintanceCount(targetUser));
    }

    private static void setScore(List<User> candidates) {
        candidates.forEach(u -> {
            u.calculateAcquaintanceScore(ACQUAINTANCE_SCORE);
            u.calculateVisitScore(VISIT_SCORE);
        });
    }

    private static List<String> getRecommendList(ArrayList<User> candidates) {
        List<String> recommend = new LinkedList<>();
        int candidateSize = candidates.size();
        int idx = 0;

        Collections.sort(candidates);
        while ((recommend.size() < RECOMMEND_COUNT_UPPER_BOUND) && (idx < candidateSize)) {
            addRecommend(recommend, candidates.get(idx));
            idx++;
        }

        return recommend;
    }

    private static void addRecommend(List<String> recommend, User user) {
        if (user.getScore() > RECOMMEND_SCORE_LOWER_BOUND) {
            recommend.add(user.getName());
        }
    }
}
