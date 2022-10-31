package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class FriendScores {
    private Map<User, Score> friendScores = new HashMap<>();
    private UserFriends userFriends;

    public FriendScores(UserFriends userFriends) {
        this.userFriends = userFriends;
    }

    public void add(List<String> friendRelation) {
        User friendA = new User(friendRelation.get(0));
        User friendB = new User(friendRelation.get(1));

        if (!userFriends.isUserFriend(friendA)
                && userFriends.isUserFriend(friendB)) {
            addFriendScore(friendA);
        }

        if (userFriends.isUserFriend(friendA)
                && !userFriends.isUserFriend(friendB)) {
            addFriendScore(friendB);
        }
    }

    public void add(String visitors) {
        User user = new User(visitors);

        if (!userFriends.isUserFriend(user))
            addVisitorScore(user);
    }

    private void addFriendScore(User user) {
        Score score = new Score();

        if (checkUserExist(user)) {
            score = friendScores.get(user);
            score.addFriendScore();
        }

        friendScores.put(user, score);
    }

    private void addVisitorScore(User user) {
        Score score = new Score();

        if (checkUserExist(user)) {
            score = friendScores.get(user);
        }

        score.addVisitorScore();
        friendScores.put(user, score);
    }

    public List<String> getRecommend() {
        List<Map.Entry<User, Score>> list =
                new ArrayList<>(friendScores.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<User, Score>>() {
            @Override
            public int compare(Map.Entry<User, Score> o1, Map.Entry<User, Score> o2) {
                if (o1.getValue().getScore() == o2.getValue().getScore()) {
                    User user1 = o1.getKey();
                    User user2 = o2.getKey();

                    return user1.getName()
                            .compareTo(user2.getName());
                }
                return o2.getValue().getScore() - o1.getValue().getScore();
            }
        });

        List<String> recommends = new ArrayList<>();

        for (Map.Entry<User, Score> userScoreEntry : list) {
            recommends.add(userScoreEntry.getKey().getName());
        }

        if (recommends.size() >= 5)
            recommends = recommends.subList(0, 5);

        return recommends;
    }

    private boolean checkUserExist(User user) {
        return friendScores.containsKey(user);
    }
}
