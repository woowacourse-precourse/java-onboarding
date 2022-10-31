package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Select new friends from candidates
 */
public class FriendSelector {

    private final Map<String, Friend> candidates;

    /**
     * Constructor with candidates
     * @param candidates new friend candidates
     */
    public FriendSelector(Map<String, Friend> candidates) {
        this.candidates = candidates;
    }

    /**
     * Select maximum 5 friends
     * @return new friend list
     */
    public List<String> select() {
        // Sort candidates
        List<String> friends = new ArrayList<>();
        // Select maximum 5 friends
        return new ArrayList<>();
    }
}
