package onboarding.problem7;

import java.util.List;
import java.util.Map;

/**
 * Recommends maximum 5 new friends
 */
public class FriendRecommender {

    private String user;
    private List<List<String>> friends;
    private List<String> visitors;

    /**
     * Constructor with user, friends, visitors
     * @param user name of user
     * @param friends friend relationship list
     * @param visitors visitor names of user sns
     */
    public FriendRecommender(String user, List<List<String>> friends, List<String> visitors) {
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }
}
