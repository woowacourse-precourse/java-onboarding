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
}
