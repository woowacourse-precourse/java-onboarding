package problem7;

import java.util.*;

public class Friend {
    private final List<String> visitors;
    private final String user;
    private final Map<String, Integer> score;
    private final Integer FRIEND_SCORE = 10;
    private final Integer VISITOR_SCORE = 1;

    public Friend(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.visitors = visitors;
        List<String> friendRelations = initFriends(friends);
        this.score = getFriends(friendRelations, friends);
        getVisitorScore(friendRelations);
    }

    private List<String> initFriends(List<List<String>> friends) {
        List<String> friendRelations = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.contains(user)) {
                int index = friend.indexOf(user);
                if (index == 0) {
                    friendRelations.add(friend.get(1));
                }
                if (index == 1) {
                    friendRelations.add(friend.get(0));
                }
            }
        }
        return friendRelations;
    }

    private Map<String, Integer> getFriends(List<String> friends, List<List<String>> relations) {
        Map<String, Integer> score = new HashMap<>();
        for (String friend : friends) {
            for (List<String> relation : relations) {
                if (relation.contains(friend) && !relation.contains(user)) {
                    int index = friend.indexOf(friend);
                    if (index == 0) {
                        setFriendScore(score, relation.get(1));
                    }
                    if (index == 1) {
                        setFriendScore(score, relation.get(0));
                    }
                }
            }
        }
        return score;
    }

    private void setFriendScore(Map<String, Integer> score, String name) {
        if(score.size() != 0 && score.containsKey(name)) {
            score.put(name, score.get(name) + FRIEND_SCORE);
            return;
        }
        score.put(name, FRIEND_SCORE);
    }

    private void setVisitorScore(Map<String, Integer> score, String name) {
        if(score.size() != 0 && score.containsKey(name)) {
            score.put(name, score.get(name) + VISITOR_SCORE);
            return;
        }
        score.put(name, VISITOR_SCORE);
    }

    private void getVisitorScore(List<String> friendRelations) {
        for(String visitor: visitors) {
            if(!friendRelations.contains(visitor)) {
                setVisitorScore(score, visitor);
            }
        }
    }

    public List<String> sortScore() {
        List<String> names = new ArrayList<>(score.keySet());
        names.sort((o1, o2) -> {
            if (score.get(o1) - score.get(o2) == 0) {
                return o1.compareTo(o2);
            }
            return score.get(o2).compareTo(score.get(o1));
        });
        return names;
    }
}
