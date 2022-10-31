package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Recommends maximum 5 new friends
 */
public class FriendRecommender {

    private final Map<String, List<String>> relationships = new HashMap<>();
    private final Map<String, Friend> scores = new HashMap<>();
    private final FriendIntroducer introducer;

    /**
     * Constructor with user, friends, visitors
     * @param user name of user
     * @param friends friend relationship list
     * @param visitors visitor names of user sns
     */
    public FriendRecommender(String user, List<List<String>> friends, List<String> visitors) {
        introducer = new FriendIntroducer(user, friends, visitors);
    }

    /**
     * Recommend new SNS friends (maximum 5)
     * @return new friend list
     */
    public List<String> recommend() {
        Map<String, Friend> candidates = introducer.introduce();
        // Create candidate list sorted by score(name if same)
        // Create new friend list(maximum 5) and return
        return new ArrayList<>();
    }
}
